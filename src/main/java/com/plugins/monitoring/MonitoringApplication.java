package com.plugins.monitoring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.plugins.monitoring.mybatis.mapper")
public class MonitoringApplication {

    public static void main(String[] args) {

        SpringApplication.run(MonitoringApplication.class, args);
    }
}
