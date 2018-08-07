package com.plugins.monitoring.web;

import com.plugins.monitoring.consist.ResultCode;
import com.plugins.monitoring.mybatis.entity.Browser;
import com.plugins.monitoring.mybatis.entity.Project;
import com.plugins.monitoring.mybatis.entity.Token;
import com.plugins.monitoring.mybatis.mapper.BrowserMapper;
import com.plugins.monitoring.mybatis.service.ProjectService;
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


/**
 * @Auther: Rockzcz
 * @Date: 2018/7/17 10:09
 * @Description: 存储用户版本信息
 */

@RestController
public class SetBasicController {

    @Autowired
    private BrowserMapper browserMapper;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ProjectService projectService;

    private Cookie[] cookies;

    private String token;

    private Integer total;

    @RequestMapping(value="/plugin/api/setBasic", method=RequestMethod.POST)

    public Object SetBasicController(Browser result, HttpServletRequest httpServletRequest) {

        Logger logger = LoggerFactory.getLogger(LoginController.class);

        cookies = httpServletRequest.getCookies();

        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("AccessToken")) {
                token = cookie.getValue();
            }
        }

        Token getId = tokenService.getToken( token );
        Project getProjectId = projectService.getPermissions( Integer.toString(getId.getRole_id()) );


        Browser browser = new Browser();
        browser.setAccount( result.getAccount() );
        browser.setSource( result.getSource() );
        browser.setUserAgent( result.getUserAgent() );
        browser.setAppVersion( result.getAppVersion() );
        browser.setLocalUrl( result.getLocalUrl() );
        browser.setSh( result.getSh() );
        browser.setSw( result.getSw() );
        browser.setCd( result.getCd() );
        browser.setProjectId( getProjectId.getPermission_id() );

        browserMapper.insert( browser );

        logger.info("brower------msg" + result);

        return ResultUtils.warn(ResultCode.Success);
    }

}
