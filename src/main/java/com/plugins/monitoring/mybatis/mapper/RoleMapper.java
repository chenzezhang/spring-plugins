package com.plugins.monitoring.mybatis.mapper;
import com.plugins.monitoring.mybatis.entity.Role;
import org.apache.ibatis.annotations.*;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/21 11:33
 * @Description: 权限分类
 */

public interface RoleMapper {

    /**
     * @return object
     */

    @Select("SELECT * FROM db_role WHERE roleName = #{roleName}")
    @Results({
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "id", column = "id")
    })
    Role getRoleName(String roleName);

    @Insert("INSERT INTO db_role(roleName) VALUES(#{roleName})")
    void insert(Role role);

    @Update("UPDATE db_role SET roleName=#{roleName} WHERE id =#{id}")
    void update(String roleName);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);


}
