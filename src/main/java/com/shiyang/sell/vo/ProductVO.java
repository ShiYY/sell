package com.shiyang.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 全部商品信息(包含类目)
 *
 * @author shiyang
 * @create 2019-08-10 4:24 PM
 **/
public class ProductVO {

    /** 在对象序列化的时候 返回给前端的就是 name*/
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVO> getProductInfoVOList() {
        return productInfoVOList;
    }

    public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
        this.productInfoVOList = productInfoVOList;
    }
}
