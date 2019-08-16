package com.shiyang.sell.service.impl;

import com.shiyang.sell.dataobject.OrderDetail;
import com.shiyang.sell.dto.OrderDto;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    
    private static final String BUYER_OPENID = "1234567";
    
    private final Logger logger = LoggerFactory.getLogger(OrderServiceImplTest.class);
    
    @Autowired
    private OrderServiceImpl orderService;
    
    @Test
    public void create() {
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName("史洋");
        orderDto.setBuyerAddress("湖南省长沙市岳麓区");
        orderDto.setBuyerPhone("13787250644");
        orderDto.setBuyerOpenid(BUYER_OPENID);
        
        // 购物车
        List<OrderDetail> orderDetails = new ArrayList<>();
    
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("1");
        orderDetail.setProductQuantity(1);
        
        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("2");
        orderDetail2.setProductQuantity(2);
        
        orderDetails.add(orderDetail);
        orderDetails.add(orderDetail2);
    
        orderDto.setOrderDetails(orderDetails);
    
        OrderDto result = orderService.create(orderDto);
        logger.info("result = {}", result);
    }
    
    @Test
    public void cancel() {
    }
    
    @Test
    public void finish() {
    }
    
    @Test
    public void paid() {
    }
    
    @Test
    public void findOne() {
        OrderDto orderDto = orderService.findOne("1565664889559244928");
        Assert.assertNotNull(orderDto);
    }
    
    @Test
    public void findList() {
    }
}