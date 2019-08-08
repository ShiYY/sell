package com.shiyang.sell.service;

import com.shiyang.sell.dataobject.ProductCategory;
import java.util.List;

/**
 * @description: 商品类目
 * @author: W
 * @create: 2019-08-08 19:45
 **/
public interface ProductCategoryService {
    
    ProductCategory findOne(Integer categoryId);
    
    List<ProductCategory> findAll();
    
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    
    ProductCategory save(ProductCategory productCategory);
}
