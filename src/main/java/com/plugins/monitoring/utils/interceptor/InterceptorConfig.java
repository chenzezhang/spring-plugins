package com.plugins.monitoring.utils.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Auther: Rockzcz
 * @Date: 2018/6/14 15:21
 * @Description:  拦截器配置
 */

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        MyInterceptor account = new MyInterceptor();

        registry.addInterceptor(account).addPathPatterns("/**");
    }
}
