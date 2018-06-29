package com.plugins.monitoring.consist;

/**
 * @Auther: Rockzcz
 * @Date: 2018/6/14 15:10
 * @Description: 统一---》返回错误码
 */

public enum ResultCode {

    Success(0,"请求成功", true),
    WEAK_NET_WORK(-1, "网络异常，请稍后重试", false),
    PASSWORD_ERROR(10001, "用户名或密码错误", false),
    PARAMETER_ERROR(405, "参数错误", false),
    REGISTER_SUCCESS(200, "注册成功", true),
    Register_ERROR(401, "用户名已经存在，请重填写用户名", false);

    private int code;
    private String msg;
    private Boolean success;

    ResultCode(int code, String msg, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
