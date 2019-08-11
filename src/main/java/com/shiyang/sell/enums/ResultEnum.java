package com.shiyang.sell.enums;

/**
 * @author shiyang
 * @create 2019-08-11 10:45 PM
 **/
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
