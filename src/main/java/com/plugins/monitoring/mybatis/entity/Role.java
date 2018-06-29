package com.plugins.monitoring.mybatis.entity;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/21 10:41
 * @Description: 权限表实体
 */
public class Role {

   private String roleName;

   private int id;

   public Role(){};

   public Role(String roleName){
       this.roleName = roleName;
   };

    public int getId() {
        return id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
