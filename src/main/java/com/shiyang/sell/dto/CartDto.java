package com.shiyang.sell.dto;

/**
 * @description: 购物车
 * @author: W
 * @create: 2019-08-12 16:20
 **/
public class CartDto {
    
    private String productId;
    
    private Integer productQuantity;
    
    public CartDto() {
    }
    
    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public Integer getProductQuantity() {
        return productQuantity;
    }
    
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
