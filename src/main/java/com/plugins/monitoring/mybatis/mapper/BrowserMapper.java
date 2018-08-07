package com.plugins.monitoring.mybatis.mapper;

import com.plugins.monitoring.mybatis.entity.Browser;
import com.plugins.monitoring.utils.FindDate;
import org.apache.ibatis.annotations.*;


/**
 * @Auther: Rockzcz
 * @Date: 2018/7/17 10:44
 * @Description: 浏览器信息
 */
public interface BrowserMapper {


    /**
     * @return object
     * @param id
     */

    @Select("SELECT * FROM db_browser WHERE id = #{id}")
    @Results({
        @Result(property = "account", column = "account"),
        @Result(property = "source", column = "source"),
        @Result(property = "user_agent", column = "user_agent"),
        @Result(property = "app_version", column = "app_version"),
        @Result(property = "local_url", column = "local_url"),
        @Result(property = "sh", column = "sh"),
        @Result(property = "sw", column = "sw"),
        @Result(property = "cd", column = "cd"),
        @Result(property = "projectId", column = "projectId")
    })
    Browser getBrowserId(String id);

    @Select("SELECT sql_calc_found_rows id, user_name, nick_name, password, role_id FROM db_user WHERE id BETWEEN #{page} AND #{pageSize}")
    @Results({
            @Result(property = "account", column = "account"),
            @Result(property = "source", column = "source"),
            @Result(property = "user_agent", column = "user_agent"),
            @Result(property = "app_version", column = "app_version"),
            @Result(property = "local_url", column = "local_url"),
            @Result(property = "sh", column = "sh"),
            @Result(property = "sw", column = "sw"),
            @Result(property = "cd", column = "cd"),
            @Result(property = "projectId", column = "projectId")
    })
    Browser queryAllCount(FindDate page);

    @Select("SELECT FOUND_ROWS()")
    Browser queryAllCountSize();


    @Insert("INSERT INTO db_browser(id, account, source, user_agent, local_url, sh, sw, cd, projectId) VALUES(#{account}, #{source}, #{user_agent}, #{local_url}, #{sh}, #{sw}, #{cd}, #{projectId})")
    int insert(Browser browser);

    @Update("UPDATE db_browser SET id=#{id} WHERE id =#{id}")
    void update(Browser id);

    @Delete("DELETE FROM db_browser WHERE id =#{id}")
    void delete(Browser id);
}
