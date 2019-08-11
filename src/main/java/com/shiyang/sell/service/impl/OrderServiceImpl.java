package com.shiyang.sell.service.impl;

import com.shiyang.sell.dto.OrderDto;
import com.shiyang.sell.repository.OrderMasterRepository;
import com.shiyang.sell.service.OrderService;
import com.shiyang.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author shiyang
 * @create 2019-08-11 10:34 PM
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository repository;
    @Autowired
    private ProductInfoService productInfoService;

    @Override
    public OrderDto create(OrderDto orderDto) {
        // 1.查询商品(数量,价格)
//        productInfoService.find

        // 2.计算总价

        // 3.写入订单数据库(orderMaster和orderDetail)

        // 4.扣库存

        return null;
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
        return null;
    }

    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }
}
