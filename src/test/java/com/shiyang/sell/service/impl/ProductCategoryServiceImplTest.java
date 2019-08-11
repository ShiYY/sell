package com.shiyang.sell.service.impl;

import static org.junit.Assert.*;

import com.shiyang.sell.dataobject.ProductCategory;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {
    
    @Autowired
    private ProductCategoryServiceImpl categoryService;
    
    @Test
    public void findOne() {
        ProductCategory category = categoryService.findOne(2);
        Assert.assertNotNull(category);
    }
    
    @Test
    public void findAll() {
        List<ProductCategory> all = categoryService.findAll();
        Assert.assertNotEquals(0, all.size());
    }
    
    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryTypeIn = categoryService
            .findByCategoryTypeIn(Arrays.asList(1, 2, 3));
        Assert.assertEquals(3, categoryTypeIn.size());
    }
    
    @Test
    public void save() {
        ProductCategory category1 = categoryService.save(new ProductCategory("红茶", 1));
        ProductCategory category2 = categoryService.save(new ProductCategory("绿茶", 2));
        ProductCategory category3 = categoryService.save(new ProductCategory("奶茶", 3));
        ProductCategory category4 = categoryService.save(new ProductCategory("黑茶", 4));
        ProductCategory category5 = categoryService.save(new ProductCategory("抹茶", 5));
//        Assert.assertNotNull(category);
    }
}