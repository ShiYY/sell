package com.shiyang.sell.repository;

import com.shiyang.sell.dataobject.ProductInfo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    
    @Autowired
    private ProductInfoRepository repository;
    
    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1");
        productInfo.setProductName("幽兰拿铁");
        productInfo.setProductPrice(new BigDecimal(15.00));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("奶茶状元");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        productInfo.setCreateTime(new Date());
        ProductInfo save = repository.save(productInfo);
        Assert.assertNotNull(save);
    }
    
    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, list.size());
    }

}