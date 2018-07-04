package com.plugins.monitoring.mybatis.entity;

/**
 * @Auther: Rockzcz
 * @Date: 2018/7/4 10:29
 * @Description: 个人信息实体
 */
public class UserInfo {
    private String username;
    private String nickname;
    private String time;

    public UserInfo(){};
    public UserInfo(String username, String nickname, String time) {
        this.username = username;
        this.nickname = nickname;
        this.time = time;
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

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

}
