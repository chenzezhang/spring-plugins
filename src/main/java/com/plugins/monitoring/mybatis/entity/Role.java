package com.plugins.monitoring.mybatis.entity;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/21 10:41
 * @Description: 权限表映射
 */
public class Role {

   private String roleName;

   public Role(){};

   public Role(String roleName){
       this.roleName = roleName;
   };

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
