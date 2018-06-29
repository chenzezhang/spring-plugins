package com.plugins.monitoring.domain.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/15 14:54
 * @Description:  权限验证
 */
public class OauthRegister {

    @NotEmpty(message="用户名不能为空")
    private String username;

    @NotEmpty(message="用户昵称不能为空")
    private String nickname;

    @NotEmpty(message="密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度为6-20位")
    private String password;

    @NotEmpty(message="必须输入部门")
    private String department;

    public void OauthRegister() {};

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return username + nickname + nickname + department;
    }
}
