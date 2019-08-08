package com.shiyang.sell.dataobject;

import com.shiyang.sell.repository.ProductCategoryRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    
    @Autowired
    private ProductCategoryRepository repository;
    
    @Test
    public void findOneTest() {
        ProductCategory category = new ProductCategory();
        category.setCategoryId(1);
        Example<ProductCategory> example = Example.of(category);
        Optional<ProductCategory> optional = repository.findOne(example);
        if (optional.isPresent()) {
            System.out.println(optional.get().toString());
        } else {
            System.out.println("null");
        }
    }
    
    @Test
    // @Transactional // 回滚事务 保证数据库中不会有测试数据
    public void saveTest() {
        ProductCategory category = new ProductCategory("素颜锡兰",5);
        ProductCategory save = repository.save(category);
        Assert.assertNotNull(save);
        // Assert.assertNotEquals(null, save);
    }
    
    @Test
    public void updateTest() {
        ProductCategory category = new ProductCategory();
        category.setCategoryId(2);
        Example<ProductCategory> example = Example.of(category);
        Optional<ProductCategory> optional = repository.findOne(example);
        if (optional.isPresent()) {
            ProductCategory productCategory = optional.get();
            productCategory.setCategoryName("幽兰拿铁");
            repository.save(productCategory);
        } else {
            System.out.println("null");
        }
    }
    
    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 2, 6);
        List<ProductCategory> categoryList = repository.findByCategoryTypeIn(list);
        Assert.assertEquals(categoryList.size(), 2);
    }
}