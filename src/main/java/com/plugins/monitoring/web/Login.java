package com.plugins.monitoring.web;

import com.plugins.monitoring.domain.user.OauthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Login {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public OauthUser Login() {

        Logger logger = LoggerFactory.getLogger(Login.class);



        OauthUser user = new OauthUser();
        user.setId(1);
        user.setUsername("zhanghaoliang");
        user.setPassword("1231");

        logger.info("登录成功------,用户名是：" + user.getUsername() + "，密码是：" + user.getPassword());

        return user;
    }
}
