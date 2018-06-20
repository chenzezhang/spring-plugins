package com.plugins.monitoring.domain.user;

/**
 * @Auther: Rockzcz
 * @Date: 2018/6/14 14:52
 * @Description: 账户信息实体
 */

public class OauthUser {

    private int id;
    private String username;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

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
