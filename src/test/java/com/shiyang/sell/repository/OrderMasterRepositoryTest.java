package com.shiyang.sell.repository;

import com.shiyang.sell.dataobject.OrderMaster;
import com.shiyang.sell.enums.OrderStatusEnum;
import com.shiyang.sell.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author shiyang
 * @create 2019-08-10 9:32 PM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2");
        orderMaster.setBuyerName("湖南师大");
        orderMaster.setBuyerAddress("湖南省长沙市岳麓区36号");
        orderMaster.setBuyerOpenid("12345");
        orderMaster.setBuyerPhone("13787250644");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.UNPAY.getCode());
        orderMaster.setOrderAmount(new BigDecimal(17));
        OrderMaster save = repository.save(orderMaster);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderMaster> result = repository.findByBuyerOpenid("123456", request);
        Assert.assertNotEquals(0, result.getTotalElements());
    }

}