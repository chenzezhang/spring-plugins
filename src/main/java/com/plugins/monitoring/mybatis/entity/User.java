package com.plugins.monitoring.mybatis.entity;

import java.util.Date;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/28 15:14
 * @Description: 用户信息实体
 */
public class User {

    private String username;
    private String nickname;
    private String password;
    private int role_id;
    private int id;
    private Date createTime;

    public User(){};

    public User(String username, String nickname, String password, int role_id){
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

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

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getRole_id() {
        return role_id;
    }
}
