package com.plugins.monitoring.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class hello {

    @RequestMapping("/hello")
    public String hello() {

        Logger logger = LoggerFactory.getLogger(hello.class);

        logger.info("拉萨路的路况发送了大富科技阿斯兰的咖啡机");

        return "hello,this is a springboot demo";
    }
}
