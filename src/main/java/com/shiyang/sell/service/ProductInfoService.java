package com.shiyang.sell.service;

import com.shiyang.sell.dataobject.ProductInfo;
import com.shiyang.sell.dto.CartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {
    
    ProductInfo findOne(String productId);
    
    /** 查询所有上架商品列表 */
    List<ProductInfo> findUpAll();
    
    Page<ProductInfo> findAll(Pageable pageable);
    
    ProductInfo save(ProductInfo productInfo);
    
    /** 加库存 */
    void increaseStock(List<CartDto> cartDtos);
    
    /** 减库存 */
    void decreaseStock(List<CartDto> cartDtos);
}
