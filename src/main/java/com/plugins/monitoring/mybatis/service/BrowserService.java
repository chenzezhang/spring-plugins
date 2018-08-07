package com.plugins.monitoring.mybatis.service;

import com.plugins.monitoring.mybatis.entity.Browser;
import com.plugins.monitoring.mybatis.mapper.BrowserMapper;
import com.plugins.monitoring.utils.FindDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther: Rockzcz
 * @Date: 2018/7/17 10:53
 * @Description:
 */

@Service
public class BrowserService {

    @Autowired
    private BrowserMapper browserMapper;

    public int insert(Browser browser) {
        return browserMapper.insert( browser );
    }

    public Browser getBrowserId(String id) {
        return browserMapper.getBrowserId( id );
    }

    public Browser queryAllCount(FindDate page) { return browserMapper.queryAllCount(page); }

    public Browser queryAllCountSize() {
         return browserMapper.queryAllCountSize();
    }
}
