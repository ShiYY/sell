package com.shiyang.sell.service;

import com.shiyang.sell.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author shiyang
 * @create 2019-08-11 10:02 PM
 **/
public interface OrderService {

    /** 创建订单 */
    OrderDto create(OrderDto orderDto);

    /** 取消订单 */
    OrderDto cancel(OrderDto orderDto);

    /** 完结订单 */
    OrderDto finish(OrderDto orderDto);

    /** 支付订单 */
    OrderDto paid(OrderDto orderDto);

    /** 查询单个订单 */
    OrderDto findOne(String orderId);

    /** 查询订单列表 */
    Page<OrderDto> findList(String buyerOpenid, Pageable pageable);

}
