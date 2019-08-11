package com.shiyang.sell.service;

import com.shiyang.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {
    
    ProductInfo findOne(String productId);
    
    /** 查询所有上架商品列表 */
    List<ProductInfo> findUpAll();
    
    Page<ProductInfo> findAll(Pageable pageable);
    
    ProductInfo save(ProductInfo productInfo);
    
    // TODO 加库存 减库存
}
