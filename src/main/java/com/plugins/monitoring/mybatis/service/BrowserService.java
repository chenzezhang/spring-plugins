package com.plugins.monitoring.mybatis.service;

import com.plugins.monitoring.mybatis.entity.Browser;
import com.plugins.monitoring.mybatis.mapper.BrowserMapper;
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
        return getBrowserId( id );
    }
}
