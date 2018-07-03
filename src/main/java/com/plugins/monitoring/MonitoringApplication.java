package com.plugins.monitoring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@MapperScan("com.plugins.monitoring.mybatis.mapper")
@EnableCaching
public class MonitoringApplication {

    public static void main(String[] args) {

        SpringApplication.run(MonitoringApplication.class, args);
    }
}
