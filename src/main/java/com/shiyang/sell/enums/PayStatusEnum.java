package com.shiyang.sell.enums;

/**
 * 支付状态
 *
 * @author shiyang
 * @create 2019-08-10 9:14 PM
 **/
public enum PayStatusEnum {

    UNPAY(0, "未支付"),
    PAID(1, "已支付"),

    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
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
