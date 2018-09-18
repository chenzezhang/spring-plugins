package com.plugins.monitoring.mybatis.service;

import com.plugins.monitoring.mybatis.entity.HtmlError;
import com.plugins.monitoring.mybatis.mapper.HtmlErrorMapper;
import com.plugins.monitoring.utils.FindDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther: Rockzcz
 * @Date: 2018/9/18 10:33
 * @Description:
 */

@Service
public class HtmlErrorService {
    @Autowired
    private HtmlErrorMapper htmlErrorMapper;

    public int insert(HtmlError htmlError) {
        return htmlErrorMapper.insert( htmlError );
    }

    public HtmlError queryAllCount(FindDate page) { return htmlErrorMapper.queryAllCount(page); }

    public HtmlError queryAllCountSize() {
        return htmlErrorMapper.queryAllCountSize();
    }
}
