package com.plugins.monitoring.web;

import com.plugins.monitoring.consist.ResultCode;
import com.plugins.monitoring.domain.user.OauthRegister;
import com.plugins.monitoring.mybatis.entity.Project;
import com.plugins.monitoring.mybatis.entity.Role;
import com.plugins.monitoring.mybatis.entity.Token;
import com.plugins.monitoring.mybatis.entity.User;
import com.plugins.monitoring.mybatis.service.ProjectService;
import com.plugins.monitoring.mybatis.service.RoleService;
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


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/15 15:06
 * @Description:  注册方法
 */

@RestController
public class RegisterController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value="/register", method = RequestMethod.POST)

    public Object register(@Valid OauthRegister userRegisterValidator, BindingResult request, HttpServletResponse response) {

        Logger logger = LoggerFactory.getLogger(LoginController.class);

        if(request.hasErrors()) {

            logger.info("用户名是：" + userRegisterValidator.getUsername() + "，昵称是：" + userRegisterValidator.getNickname());

            return ResultUtils.warn(401, request.getFieldError().getDefaultMessage(), false);
        }

        if (getRole(userRegisterValidator) == null) {

            logger.info("getRole:" + getRole(userRegisterValidator) + ",用户不存在，创建-----");

            Role role = new Role(userRegisterValidator.getDepartment());

            logger.info("getRole: --------" + getRole(userRegisterValidator));

            logger.info(role.getRoleName());

            roleService.insert(role);
        }

        /**
         * 部门已经存在
         * 比对数据库中是否存在用户名。
         */

        User getUserName = userService.getUserName(userRegisterValidator.getUsername());
        Role role = getRole(userRegisterValidator);

        if(getUserName != null) {

            logger.info("数据库查到的user_name：" + userService.getUserName(userRegisterValidator.getUsername()) + "在数据库中已经存在");

            return ResultUtils.warn(ResultCode.Register_ERROR);
        }

        /**
         * 部门存在，数据库中没有用户名。
         * 开始注册。
         */

        User user = new User(userRegisterValidator.getUsername(), userRegisterValidator.getNickname(), userRegisterValidator.getPassword(), role.getId());

        userService.addUser(user);

        // 插入分类权限表
        Project project = new Project(1, role.getId());
        projectService.insert(project);

        // 插入登录权限控制
        User getUser =  userService.getUserName(userRegisterValidator.getUsername());

        String access_token = MD5Util.MD5(userRegisterValidator.toString());
        Token token = new Token(access_token, getUser.getId(), role.getId());
        tokenService.insert( token );

        logger.info("生成的token是:" + access_token);

//      用户访问过之后重新设置用户的访问时间，存储到cookie中，然后发送到客户端浏览器
        Cookie cookie = new Cookie("AccessToken", access_token);//创建一个cookie，cookie的名字是AccessToken
//      设置Cookie的有效期为1小时
        cookie.setMaxAge(60*60);
        cookie.setPath("/");
//      将cookie对象添加到response对象中，这样服务器在输出response对象中的内容时就会把cookie也输出到客户端浏览器
        response.addCookie(cookie);

        logger.info("用户名是：" + userRegisterValidator.getUsername() + "，昵称是：" + userRegisterValidator.getNickname() + "，部门是:" + userRegisterValidator.getDepartment());

        return ResultUtils.success(ResultCode.REGISTER_SUCCESS, userRegisterValidator);
    }

    public Role getRole(OauthRegister userRegisterValidator){
        return roleService.getRoleName(userRegisterValidator.getDepartment());
    }
}

