package com.shiyang.sell.utils;

import com.shiyang.sell.vo.ResultVO;

/**
 * @author shiyang
 * @create 2019-08-10 6:41 PM
 **/
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        return new ResultVO(0, "success", object);
    }

    public static ResultVO success() {
        return new ResultVO(0, "success", null);
    }

    public static ResultVO error(Integer code, String msg) {
        return new ResultVO(code, msg, null);
    }
}
