package com.plugins.monitoring.mybatis.mapper;

import com.plugins.monitoring.mybatis.entity.User;
import org.apache.ibatis.annotations.*;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/28 15:18
 * @Description: 用户分类
 */

@Mapper
public interface UserMapper {
    /**
     * @return object
     */

    @Select("SELECT * FROM db_user WHERE user_name = #{username}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "user_name"),
            @Result(property = "nickname", column = "nick_name"),
            @Result(property = "password", column = "password"),
    })
    User getUserName(String username);

    @Select("SELECT * FROM db_user WHERE id = #{id}")
    @Results({
            @Result(property = "username", column = "user_name"),
            @Result(property = "nickname", column = "nick_name"),
            @Result(property = "createTime", column = "create_time")
    })
    User getUserInfo(int id);

    @Insert("INSERT INTO db_user(user_name, nick_name, password, role_id) VALUES(#{username}, #{nickname}, #{password}, #{role_id})")
    int insert(User user);

    @Update("UPDATE db_user SET user_name=#{user_name} WHERE id =#{id}")
    int update(User user_name);

    @Delete("DELETE FROM db_user WHERE id =#{id}")
    void delete(User id);
}
