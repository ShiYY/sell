package com.shiyang.sell.vo;

/**
 * @description: HTTP请求返回的最外层对象
 * @author: W
 * @create: 2019-08-09 15:01
 **/
public class ResultVO<T> {
    
    /** 响应码 */
    private Integer code;
    
    /** 提示信息 */
    private String msg;
    
    /** 具体内容 */
    private T data;
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
}
