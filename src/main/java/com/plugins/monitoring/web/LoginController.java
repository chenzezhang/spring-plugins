package com.plugins.monitoring.web;

import com.plugins.monitoring.consist.ResultCode;
import com.plugins.monitoring.domain.user.OauthUser;
import com.plugins.monitoring.mybatis.entity.Token;
import com.plugins.monitoring.mybatis.entity.User;
import com.plugins.monitoring.mybatis.service.TokenService;
import com.plugins.monitoring.mybatis.service.UserService;
import com.plugins.monitoring.utils.MD5Util;
import com.plugins.monitoring.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    public Object Login(@Valid OauthUser userLoginValidator, BindingResult request, HttpServletResponse response) {

        Logger logger = LoggerFactory.getLogger(LoginController.class);

        if(request.hasErrors()) {

            logger.info("用户名是：" + userLoginValidator.getUsername() + "，昵称是：" + userLoginValidator.getPassword());

            return ResultUtils.warn(401, request.getFieldError().getDefaultMessage(), false);
        }

        User user = userService.getUserName( userLoginValidator.getUsername() );

        if(user == null) {
            logger.info("用户名不存在");
            return ResultUtils.warn( ResultCode.PASSWORD_ERROR );
        }

        String md5Password = MD5Util.MD5(userLoginValidator.getPassword());

        if(!user.getPassword().equals( md5Password )) {
            logger.info("密码错误");
            return ResultUtils.warn( ResultCode.PASSWORD_ERROR );
        }

        String access_token = MD5Util.MD5(userLoginValidator.getUsername());

        /**
         * @param 先判断数据库是否存在token，存在删除，赋值
         */

        Token getToken = tokenService.getToken( access_token );

        if(getToken != null) {

            /**
             * 存在登录态，并且是老用户，直接更新登录态
             */
            tokenService.update( access_token );

        } else {

            /**
             * 不存在第一次登录，创建登录态。
             */
            Token token = new Token(access_token, user.getId(), user.getRole_id());

            tokenService.insert( token );

        }

        // 用户访问过之后重新设置用户的访问时间，存储到cookie中，然后发送到客户端浏览器
        Cookie cookie = new Cookie("AccessToken", access_token);//创建一个cookie，cookie的名字是AccessToken
        // 设置Cookie的有效期为1小时
        cookie.setMaxAge(60*60);
        cookie.setPath("/");
        // 将cookie对象添加到response对象中，这样服务器在输出response对象中的内容时就会把cookie也输出到客户端浏览器
        response.addCookie(cookie);

        logger.info("登录成功------,用户名是：" + userLoginValidator.getUsername() + "，密码是：" + userLoginValidator.getPassword());

        return ResultUtils.warn(ResultCode.Success);
    }



}
