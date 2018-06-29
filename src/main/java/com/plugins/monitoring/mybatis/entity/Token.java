package com.plugins.monitoring.mybatis.entity;

/**
 * @Auther: Rockzcz
 * @Date: 2018/6/29 10:19
 * @Description: token 实体映射
 */
public class Token {
    private String id;
    private int user_id;
    private int role_id;

    public Token(){};

    public Token(String id, int user_id, int role_id){
        this.id = id;
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getRole_id() {
        return role_id;
    }
}
