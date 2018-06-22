package com.plugins.monitoring.web;

import com.plugins.monitoring.domain.user.OauthUser;
import com.plugins.monitoring.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object Login(@Valid OauthUser userLoginValidator, BindingResult request) {

        Logger logger = LoggerFactory.getLogger(LoginController.class);

        if(request.hasErrors()) {

            logger.info("用户名是：" + userLoginValidator.getUsername() + "，昵称是：" + userLoginValidator.getPassword());

            return ResultUtils.warn(401, request.getFieldError().getDefaultMessage(), false);
        }

        logger.info("登录成功------,用户名是：" + userLoginValidator.getUsername() + "，密码是：" + userLoginValidator.getPassword());

        return userLoginValidator;
    }



}
