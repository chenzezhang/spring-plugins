package com.plugins.monitoring.web;

import com.plugins.monitoring.domain.user.OauthUser;
import com.plugins.monitoring.mybatis.entity.Role;
import com.plugins.monitoring.mybatis.mapper.RoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private RoleMapper roleMapper;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public OauthUser Login() {

        Logger logger = LoggerFactory.getLogger(LoginController.class);

        OauthUser user = new OauthUser();
        user.setId(1);
        user.setUsername("zhanghaoliang");
        user.setPassword("1231");

        Role role = roleMapper.getRoleName("理财");


        logger.info("-----------------------------------");


        logger.info("role: --------" + role.toString());



        logger.info("登录成功------,用户名是：" + user.getUsername() + "，密码是：" + user.getPassword());

        return user;
    }



}
