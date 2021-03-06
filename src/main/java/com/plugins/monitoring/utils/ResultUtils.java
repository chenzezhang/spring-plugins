package com.plugins.monitoring.utils;

import com.plugins.monitoring.consist.ResultCode;
import com.plugins.monitoring.domain.utils.Result;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/14 15:08
 * @Description: 默认返回字段定义
 */
public class ResultUtils {

    public static Result<Object> success(ResultCode resultCode, Object data) {

        return new Result<Object>(resultCode, data);
    }

    public static Result<Object> warn(int code, String msg, Boolean success) {
        Result<Object> result = new Result<Object> ();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(success);
        return result;
    }

    public static Result<Object> warn(ResultCode resultCode) {

        return new Result<Object>(resultCode);
    }
}
