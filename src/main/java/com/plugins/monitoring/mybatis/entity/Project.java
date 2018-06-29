package com.plugins.monitoring.mybatis.entity;

/**
 * @Auther: Rockzcz
 * @Date: 2018/6/29 10:08
 * @Description: 分类权限映射
 */
public class Project {
    private int permission_id;
    private int role_id;

    public Project(){};

    public Project( int permission_id, int role_id){
        this.permission_id = permission_id;
        this.role_id = role_id;
    };

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
