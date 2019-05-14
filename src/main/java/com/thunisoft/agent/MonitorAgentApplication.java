package com.thunisoft.agent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.thunisoft.agent.dao")
public class MonitorAgentApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitorAgentApplication.class, args);
    }
}
