package com.shiyang.sell.repository;

import com.shiyang.sell.dataobject.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author shiyang
 * @create 2019-08-10 9:30 PM
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
