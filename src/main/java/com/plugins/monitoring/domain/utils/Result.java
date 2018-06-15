package com.plugins.monitoring.domain.utils;

import com.plugins.monitoring.consist.ResultCode;

/**
 * @Auther: Rockzcz
 * @Date: 2018/6/14 15:12
 * @Description: 默认错误字段实体
 */

public class Result<T> {

    private int code;
    private String msg;
    private T data;
    private Boolean success;

    public Result() {}

    public Result(ResultCode resultCode, T data) {
        this(resultCode);
        this.data = data;
    }

    public Result(int code, String msg, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.success = resultCode.getSuccess();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
