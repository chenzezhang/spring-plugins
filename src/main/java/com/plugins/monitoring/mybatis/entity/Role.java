package com.plugins.monitoring.mybatis.entity;

/**
 * @Auther: Rockzcz
 * @Date: 2018/6/21 10:41
 * @Description: 权限表映射
 */
public class Role {

    private Long id;

    private String roleName;

    public Role(){};

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRoleName(String roleName) {

        this.roleName = roleName;
    }

    public String getRoleName() {

        return roleName;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", roleName="+ roleName +"]";
    }
}
