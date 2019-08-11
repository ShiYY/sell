package com.shiyang.sell.repository;

import com.shiyang.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shiyang
 * @create 2019-08-11 9:38 PM
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2");
        orderDetail.setOrderId("1");
        orderDetail.setProductId("2");
        orderDetail.setProductName("幽兰拿铁");
        orderDetail.setProductPrice(new BigDecimal(15));
        orderDetail.setProductQuantity(1);
        OrderDetail save = repository.save(orderDetail);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> result = repository.findByOrderId("1");
        Assert.assertNotEquals(0, result.size());
    }

}