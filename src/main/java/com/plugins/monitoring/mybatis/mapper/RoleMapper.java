package com.plugins.monitoring.mybatis.mapper;
import com.plugins.monitoring.mybatis.entity.Role;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/21 11:33
 * @Description: 权限分类
 */

public interface RoleMapper {

    /**
     * @return object
     */

    @Select("SELECT * FROM role WHERE roleName = #{roleName}")
    @Results({
            @Result(property = "roleName", column = "roleName")
    })

    Role getRoleName(String roleName);

    @Insert("INSERT INTO role(roleName) VALUES(#{roleName})")
    void insert(Role role);

    @Update("UPDATE role SET roleName=#{roleName} WHERE id =#{id}")
    void update(Role role);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);
}
