package com.plugins.monitoring.web;

import com.plugins.monitoring.consist.ResultCode;
import com.plugins.monitoring.mybatis.entity.HtmlError;
import com.plugins.monitoring.mybatis.entity.Project;
import com.plugins.monitoring.mybatis.entity.Token;
import com.plugins.monitoring.mybatis.mapper.HtmlErrorMapper;
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
 * @Date: 2018/9/18 14:59
 * @Description:
 */

@RestController
public class SetHtmlErrorController {

    @Autowired
    public HtmlErrorMapper htmlErrorMapper;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ProjectService projectService;

    private Cookie[] cookies;

    private String token;

    @RequestMapping(value="/plugin/api/setHtmlError", method=RequestMethod.POST)


    public Object SetHtmlErrorController(HtmlError result, HttpServletRequest httpServletRequest) {

        Logger logger = LoggerFactory.getLogger(LoginController.class);

        cookies = httpServletRequest.getCookies();

        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("AccessToken")) {
                token = cookie.getValue();
            }
        }

        Token getId = tokenService.getToken( token );
        Project getProjectId = projectService.getPermissions( Integer.toString(getId.getRole_id()) );

        HtmlError htmlError = new HtmlError();

        htmlError.setType( result.type );
        htmlError.setbType( result.bType );
        htmlError.setsMsg( result.sMsg );
        htmlError.setsUrl( result.sUrl );
        htmlError.setsLine( result.sLine );
        htmlError.setsCol( result.sCol );
        htmlError.seteObj( result.eObj );
        htmlError.setsTime( result.sTime );
        htmlError.setProjectId( getProjectId.getPermission_id() );

        htmlErrorMapper.insert( htmlError );

        logger.info("htmlError------msg" + result);

        return ResultUtils.warn(ResultCode.Success);
    }
}
