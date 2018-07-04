package com.plugins.monitoring.web;

import com.plugins.monitoring.mybatis.entity.Token;
import com.plugins.monitoring.mybatis.entity.User;
import com.plugins.monitoring.mybatis.entity.UserInfo;
import com.plugins.monitoring.mybatis.service.TokenService;
import com.plugins.monitoring.mybatis.service.UserService;
import com.plugins.monitoring.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


/**
 * @Auther: Rockzcz
 * @Date: 2018/7/4 10:20
 * @Description: 个人信息接口
 */

@RestController
public class UserInfoController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    private Cookie[] cookies;

    private String token;

    @RequestMapping(value="/plugin/api/userInfo", method = RequestMethod.GET)

    public UserInfo userInfo(HttpServletRequest httpServletRequest){

        cookies = httpServletRequest.getCookies();

        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("AccessToken")) {
             token = cookie.getValue();
            }
        }

        UserInfo userinfo = new UserInfo();

        Token getToken = tokenService.getToken( token );

        User user = userService.getUserId( getToken.getUser_id());



        userinfo.setUsername(user.getUsername());
        userinfo.setNickname( user.getNickname());

        String time = DateUtil.stampToDate( String.valueOf( user.getCreateTime() ) );;
        userinfo.setTime(time);


        return userinfo;
    }
}
