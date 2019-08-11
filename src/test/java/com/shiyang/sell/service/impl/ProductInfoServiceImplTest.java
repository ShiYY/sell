package com.shiyang.sell.service.impl;

import com.shiyang.sell.dataobject.ProductInfo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    
    @Autowired
    private ProductInfoServiceImpl productService;
    
    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("1");
        Assert.assertNotNull(productInfo);
        Assert.assertEquals("1", productInfo.getProductId());
    }
    
    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        Assert.assertNotNull(upAll);
        Assert.assertNotEquals(0, upAll.size());
    }
    
    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        Page<ProductInfo> all = productService.findAll(pageRequest);
        Assert.assertNotEquals(0, all.getTotalElements());
        // System.out.println(all.getTotalElements());
    }
    
    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("2");
        productInfo.setProductName("幽兰拿铁");
        productInfo.setProductPrice(new BigDecimal(15.00));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("奶茶状元");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        productInfo.setCreateTime(new Date());
        ProductInfo save = productService.save(productInfo);
        Assert.assertNotNull(save);
    }
}