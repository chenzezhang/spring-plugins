package com.plugins.monitoring.domain;

import org.apache.tomcat.util.http.parser.Cookie;

/**
 * @Auther: Rockzcz
 * @Date: 2018/6/14 14:43
 * @Description: 获取token实体
 */
public class GetToken {

    private Cookie[] cookies;

    public Cookie[] getCookies() {
        return cookies;
    }

    public void setCookies(Cookie[] cookies) {
        this.cookies = cookies;
    }
}