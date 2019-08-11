package com.shiyang.sell.repository;

import com.shiyang.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shiyang
 * @create 2019-08-10 9:27 PM
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 查询买家订单
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
