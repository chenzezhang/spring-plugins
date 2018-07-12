package com.plugins.monitoring.web;

import com.plugins.monitoring.consist.ResultCode;
import com.plugins.monitoring.mybatis.entity.Token;
import com.plugins.monitoring.mybatis.service.TokenService;
import com.plugins.monitoring.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Auther: Rockzcz
 * @Date: 2018/7/12 16:16
 * @Description: 登出接口
 */

@RestController
public class LogoutController {

    @Autowired
    private TokenService tokenService;

    private Cookie[] cookies;

    private String token;

    @RequestMapping(value="/plugin/api/logout", method = RequestMethod.POST)

    public Object logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){

        Logger logger = LoggerFactory.getLogger(LoginController.class);

        cookies = httpServletRequest.getCookies();

        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("AccessToken")) {
                token = cookie.getValue();
            }
        }

        Token id = tokenService.getToken( token );

        tokenService.delete( id );

        //清空本地cookie
        Cookie cookie = new Cookie("AccessToken", "");

        // 将cookie对象添加到response对象中，这样服务器在输出response对象中的内容时就会把cookie也输出到客户端浏览器
        httpServletResponse.addCookie(cookie);

        logger.info( "数据库清理cookie完成，浏览器端cookie清理完成。。。" );

        return ResultUtils.warn( ResultCode.Success );
    }
}
