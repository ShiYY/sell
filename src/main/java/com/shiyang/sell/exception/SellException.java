package com.shiyang.sell.exception;

import com.shiyang.sell.enums.ResultEnum;

/**
 * @author shiyang
 * @create 2019-08-11 10:57 PM
 **/
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
