package com.plugins.monitoring.domain.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/14 14:52
 * @Description: 账户信息实体
 */

public class OauthUser {

    @NotEmpty(message="用户名不能为空")
    private String username;

    @NotEmpty(message="密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度为6-20位")
    private String password;

    public void setUsername(String username) {

        this.username = username;
    }

    public String getUsername() {

        return username;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getPassword() {

        return password;
    }
}
