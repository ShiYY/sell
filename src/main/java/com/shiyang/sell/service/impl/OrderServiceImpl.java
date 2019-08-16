package com.shiyang.sell.service.impl;

import com.shiyang.sell.dataobject.OrderDetail;
import com.shiyang.sell.dataobject.OrderMaster;
import com.shiyang.sell.dataobject.ProductInfo;
import com.shiyang.sell.dto.CartDto;
import com.shiyang.sell.dto.OrderDto;
import com.shiyang.sell.enums.ResultEnum;
import com.shiyang.sell.exception.SellException;
import com.shiyang.sell.repository.OrderDetailRepository;
import com.shiyang.sell.repository.OrderMasterRepository;
import com.shiyang.sell.service.OrderService;
import com.shiyang.sell.service.ProductInfoService;
import com.shiyang.sell.utils.KeyUtil;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * @author shiyang
 * @create 2019-08-11 10:34 PM
 **/
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderMasterRepository masterRepository;
    @Autowired
    private OrderDetailRepository detailRepository;
    @Autowired
    private ProductInfoService productInfoService;
    
    @Override
    @Transactional // 抛出异常回滚事务
    public OrderDto create(OrderDto orderDto) {
        String orderId = KeyUtil.genUniqueKey();
        // 订单总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        // 1.查询商品(数量,价格)
        List<OrderDetail> orderDetails = orderDto.getOrderDetails();
        for (OrderDetail orderDetail : orderDetails) {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (null == productInfo) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            orderAmount = orderAmount.add(productInfo.getProductPrice()
                .multiply(new BigDecimal(orderDetail.getProductQuantity())));
            // 订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            // TODO 使用BeanUtils还是有风险的 createTime updateTime 不容易控制
            orderDetail.setCreateTime(new Date());
            orderDetail.setUpdateTime(new Date());
            detailRepository.save(orderDetail);
        }
        
        // 3.写入订单数据库(orderMaster和orderDetail)
        OrderMaster orderMaster = new OrderMaster();
        // BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setBuyerName(orderDto.getBuyerName());
        orderMaster.setBuyerAddress(orderDto.getBuyerAddress());
        orderMaster.setBuyerPhone(orderDto.getBuyerPhone());
        orderMaster.setBuyerOpenid(orderDto.getBuyerOpenid());
        orderMaster.setCreateTime(new Date());
        masterRepository.save(orderMaster);
        // 4.扣库存 TODO 空库存存在并发问题 专业术语:超卖 后面使用redis锁机制优化
        List<CartDto> cartDtos = orderDetails.stream()
            .map(d -> new CartDto(d.getProductId(), d.getProductQuantity()))
            .collect(Collectors.toList());
        productInfoService.decreaseStock(cartDtos);
        return orderDto;
    }
    
    @Override
    public OrderDto cancel(OrderDto orderDto) {
        return null;
    }
    
    @Override
    public OrderDto finish(OrderDto orderDto) {
        return null;
    }
    
    @Override
    public OrderDto paid(OrderDto orderDto) {
        return null;
    }
    
    @Override
    public OrderDto findOne(String orderId) {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        Example<OrderMaster> example = Example.of(orderMaster);
        Optional<OrderMaster> optional = masterRepository.findOne(example);
        if (!optional.isPresent()) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> details = detailRepository.findByOrderId(orderId);
        if (CollectionUtils.isEmpty(details)) {
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(optional.get(), orderDto);
        orderDto.setOrderDetails(details);
        return orderDto;
    }
    
    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasters = masterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        // Page<OrderDto> page = new PageImpl<>(orderMasters.get);
        new ArrayList<>();
        return null;
    }
    
}
