package com.plugins.monitoring.web;

import com.alibaba.fastjson.JSON;
import com.plugins.monitoring.mybatis.entity.Browser;
import com.plugins.monitoring.mybatis.service.BrowserService;
import com.plugins.monitoring.utils.FindDataResult;
import com.plugins.monitoring.utils.FindDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Auther: Rockzcz
 * @Date: 2018/8/7 12:06
 * @Description:
 */

@RestController
public class GetBasicController {

    @Autowired
    private BrowserService browserService;

    /**
     * @param 此处对应返回数据,前端需要分页展示。
     * @param param: { page: 1, pageSize: 10}
     */

    @RequestMapping(value="/plugin/api/getBasic", method=RequestMethod.GET)

    public FindDataResult getBasicController(@RequestParam("currentPage") Integer currentPage, @RequestParam("countPerPage") Integer countPerPage){

        Logger logger = LoggerFactory.getLogger(LoginController.class);

        if(currentPage <= 0) {
            currentPage = 1;
        }

        if(countPerPage <= 0){
            countPerPage = 10;
        }

        FindDataResult result = new FindDataResult();

        try {

            FindDate page = new FindDate();

            page.setPage( (currentPage - 1) * 10 );
            page.setPageSize( (currentPage - 1) * 10 + countPerPage );
            page.setProjectId( 1 );

            Browser list = browserService.queryAllCount(page);

            Browser total = browserService.queryAllCountSize();

            System.out.print( total );

            result.setCode( 200 );
            result.setData( list );
            result.setTotal( (int)total.getTotal() );
            result.setMessage( "请求成功" );

            System.out.print( result );

        } catch(Exception e) {

            logger.info( "error = " + e.getClass().getSimpleName() + " " + e.getMessage() );
            result.setCode( 401 );
            result.setMessage( "信息获取失败！请稍后重试....." );
        }

        return result;
    }
}
