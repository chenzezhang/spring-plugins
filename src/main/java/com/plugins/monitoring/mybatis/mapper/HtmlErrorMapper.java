package com.plugins.monitoring.mybatis.mapper;

import com.plugins.monitoring.mybatis.entity.HtmlError;
import com.plugins.monitoring.utils.FindDate;
import org.apache.ibatis.annotations.*;


/**
 * @Auther: Rockzcz
 * @Date: 2018/9/18 10:20
 * @Description:
 */

public interface HtmlErrorMapper {


    /**
     * @return object
     * @param
     */

    @Select("SELECT * FROM db_htmlError WHERE id BETWEEN #{page} AND #{pageSize}")
    @Results({
            @Result(property = "type", column = "type"),
            @Result(property = "s_msg", column = "s_msg"),
            @Result(property = "s_url", column = "s_url"),
            @Result(property = "s_line", column = "s_line"),
            @Result(property = "s_col", column = "s_col"),
            @Result(property = "e_obj", column = "e_obj"),
            @Result(property = "s_time", column = "s_time"),
            @Result(property = "b_type", column = "b_type"),
    })
    HtmlError queryAllCount(FindDate page);

    @Select("SELECT FOUND_ROWS()")
    HtmlError queryAllCountSize();


    @Insert("INSERT INTO db_htmlError(id, type, s_msg, s_url, s_line, s_col, e_obj, s_time, b_type, projectId) VALUES(#{type}, #{sMsg}, #{sUrl}, #{sLine}, #{sCol}, #{eObj}, #{sTime}, #{bType}, #{projectId})")
    int insert(HtmlError htmlError);

    @Update("UPDATE db_htmlError SET id=#{id} WHERE id =#{id}")
    void update(HtmlError id);

    @Delete("DELETE FROM db_htmlError WHERE id =#{id}")
    void delete(HtmlError id);
}
