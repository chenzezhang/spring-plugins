package com.plugins.monitoring.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import com.plugins.monitoring.mybatis.entity.Token;


/**
 * @Auther: Rockzcz
 * @Date: 2018/6/29 10:23
 * @Description: token 数据银蛇
 */
public interface TokenMapper {

    /**
     * @return object
     */

    @Select("SELECT * FROM db_token WHERE id = #{token}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "role_id", column = "role_id")
    })
    Token getToken(char id);

    @Insert("INSERT INTO db_token(id, user_id, role_id) VALUES(#{id}, #{user_id}, #{role_id})")
    void insert(Token token);

    @Update("UPDATE db_token SET id=#{id} WHERE id =#{id}")
    void update(char id);

    @Delete("DELETE FROM db_token WHERE id =#{id}")
    void delete(Long id);


}
