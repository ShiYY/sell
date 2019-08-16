package com.shiyang.sell.service.impl;

import com.shiyang.sell.dataobject.ProductInfo;
import com.shiyang.sell.dto.CartDto;
import com.shiyang.sell.enums.ProductStatusEnum;
import com.shiyang.sell.enums.ResultEnum;
import com.shiyang.sell.exception.SellException;
import com.shiyang.sell.repository.ProductInfoRepository;
import com.shiyang.sell.service.ProductInfoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description: 商品信息
 * @author: W
 * @create: 2019-08-09 14:07
 **/
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    
    @Autowired
    private ProductInfoRepository repository;
    
    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(productId);
        Example<ProductInfo> example = Example.of(productInfo);
        Optional<ProductInfo> optional = repository.findOne(example);
        return optional.isPresent() ? optional.get() : null;
    }
    
    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
    
    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
    
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
    
    @Override
    public void increaseStock(List<CartDto> cartDtos) {
        for (CartDto cartDto : cartDtos) {
        
        }
    
    }
    
    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtos) {
        for (CartDto cartDto : cartDtos) {
            ProductInfo productInfo = this.findOne(cartDto.getProductId());
            if (null == productInfo) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
    
            Integer result = productInfo.getProductStock() - cartDto.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_NOT_ENOUGH);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
