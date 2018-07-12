package com.plugins.monitoring.mybatis.mapper;

import com.plugins.monitoring.mybatis.entity.Project;
import org.apache.ibatis.annotations.*;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/29 10:11
 * @Description:
 */
public interface ProjectMapper {

    /**
     * @return object
     * @param role_id
     */

    @Select("SELECT * FROM db_permissions WHERE roleName = #{roleName}")
    @Results({
            @Result(property = "permission_id", column = "permission_id"),
            @Result(property = "role_id", column = "role_id")
    })
    Project getPermissions(String role_id);

    @Insert("INSERT INTO db_permissions(permissions_id, role_id) VALUES(#{permission_id}, #{role_id})")
    int insert(Project project);

    @Update("UPDATE db_permissions SET permissions_id=#{permissions_id}, role_id = #{role_id} WHERE id =#{id}")
    void update(Project roleName);

    @Delete("DELETE FROM db_permissions WHERE id =#{id}")
    void delete(Project id);


}
