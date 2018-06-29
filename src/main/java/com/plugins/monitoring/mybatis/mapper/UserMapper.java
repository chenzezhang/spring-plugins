package com.plugins.monitoring.mybatis.mapper;

import com.plugins.monitoring.mybatis.entity.User;
import org.apache.ibatis.annotations.*;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/28 15:18
 * @Description: 用户分类
 */
public interface UserMapper {
    /**
     * @return object
     */

    @Select("SELECT * FROM db_user WHERE user_name = #{username}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "user_name")
    })
    User getUserName(String username);

    @Insert("INSERT INTO db_user(user_name, nick_name, password, role_id) VALUES(#{username}, #{nickname}, #{password}, #{role_id})")
    void insert(User user);

    @Update("UPDATE db_user SET roleName=#{user_name} WHERE id =#{id}")
    void update(String user_name);

    @Delete("DELETE FROM db_user WHERE id =#{id}")
    void delete(Long id);


}
