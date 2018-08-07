package com.plugins.monitoring.utils;

/**
 * @Auther: Rockzcz
 * @Date: 2018/8/7 09:13
 * @Description:
 */
public class FindDataResult {
    public int total;
    public Object data;
    public Integer code;
    public String message;

    public FindDataResult() {};

    public FindDataResult(int total, Object data, Integer code, String message){
        this.total = total;
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
