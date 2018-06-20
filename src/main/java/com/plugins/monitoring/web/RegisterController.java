package com.plugins.monitoring.web;

import com.plugins.monitoring.domain.user.OauthRegister;
import com.plugins.monitoring.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/15 15:06
 * @Description:  注册方法
 */

@RestController
public class RegisterController {

    @RequestMapping(value="/register", method = RequestMethod.POST)

    public Object register(@Valid OauthRegister userRegisterValidator, BindingResult request) {
        Logger logger = LoggerFactory.getLogger(LoginController.class);

        if(request.hasErrors()) {

            logger.info("用户名是：" + userRegisterValidator.getUsername() + "，昵称是：" + userRegisterValidator.getNickname());

            return ResultUtils.warn(401, request.getFieldError().getDefaultMessage(), false);
        }


        logger.info("用户名是：" + userRegisterValidator.getUsername() + "，昵称是：" + userRegisterValidator.getNickname() + "，部门是:" + userRegisterValidator.getDepartment());


        return userRegisterValidator;
    }
}
