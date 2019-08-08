package com.shiyang.sell.service.impl;

import com.shiyang.sell.dataobject.ProductCategory;
import com.shiyang.sell.repository.ProductCategoryRepository;
import com.shiyang.sell.service.ProductCategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * @description: 商品类目
 * @author: W
 * @create: 2019-08-08 19:45
 **/
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    
    @Autowired
    private ProductCategoryRepository repository;
    
    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory category = new ProductCategory();
        category.setCategoryId(categoryId);
        Example<ProductCategory> example = Example.of(category);
        Optional<ProductCategory> optional = repository.findOne(example);
        return optional.isPresent() ? optional.get() : null;
    }
    
    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }
    
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }
    
    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
