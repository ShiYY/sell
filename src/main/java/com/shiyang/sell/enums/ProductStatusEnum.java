package com.shiyang.sell.enums;

/**
 * 商品状态
 */
public enum ProductStatusEnum {
    
    UP(0, "在架"),
    DOWN(1, "下架"),
    ;
    
    private Integer code;
    
    private String desc;
    
    ProductStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    
    public Integer getCode() {
        return code;
    }
}
