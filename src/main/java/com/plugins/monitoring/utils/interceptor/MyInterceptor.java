package com.plugins.monitoring.utils.interceptor;

import com.alibaba.fastjson.JSON;
import com.plugins.monitoring.domain.utils.Result;
import com.plugins.monitoring.mybatis.entity.Token;
import com.plugins.monitoring.mybatis.service.TokenService;
import com.plugins.monitoring.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/14 15:28
 * @Description:  拦截器
 */

public class MyInterceptor implements HandlerInterceptor {

    private static String token;
    private Cookie[] cookies;

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {

        cookies = httpServletRequest.getCookies();

        login login = new login();
        login.setHttpServletResponse(httpServletResponse);

        if(cookies == null || cookies.length == 0) {
            login.result();
            return false;
        }

        // 判断AccessToken 是否存在。
        Boolean isLogin = isToken(cookies, "AccessToken");

        if(!isLogin) {

            login.result();
            return false;

        } else {

            try {
                Token getToken = tokenService.getToken( token );
                if(null == getToken ){
                    login.result();
                    return false;
                }
                return true;

            } catch (Exception e) {

            }
        }
        return true;
    }

    //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws IOException {

        login login = new login();

        if(httpServletResponse.getStatus()==500 || httpServletResponse.getStatus() == 404){
            login.result();
        }
    }

    //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
    }

    /**
     * 遍历cookie，是否存在accessToken
     * @param arr
     * @param targetValue
     * @return
     */

    public static boolean isToken(Cookie[] arr, String targetValue) {
        for(Cookie s: arr){
            if(s.getName().equals(targetValue)) {
                token = s.getValue();
                return true;
            }
        }
        return false;
    }


}

/**
 * 提取公共方法,返回前端数据格式
 * @author Rockzcz
 *
 */

class login {

    private HttpServletResponse httpServletResponse;

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    void result() throws IOException {

        Map result = new HashMap();

        Result<Object> rt = ResultUtils.warn(401, "登录失败", false);

        result.put("msg", rt.getMsg());
        result.put("success", rt.getSuccess());
        result.put("code", rt.getCode());

        String jsonString = JSON.toJSONString(result);

        httpServletResponse.setStatus(401);

        httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");

        httpServletResponse.setCharacterEncoding("UTF-8");

        PrintWriter write = httpServletResponse.getWriter();
        write.write(jsonString);
        write.flush();

        Logger logger = LoggerFactory.getLogger(login.class);

        logger.info("这里是拦截器，没有token不能登录");

    }
}
