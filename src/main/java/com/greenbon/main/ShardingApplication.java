package com.greenbon.main;


import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.infra.config.datasource.DataSourceConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.greenbon.**.dao")
@ComponentScan(basePackages = {"com.greenbon.**"})
@Slf4j
public class ShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
        log.info("####################################################");
        log.info("####################### 启动完成 ####################");
        log.info("####################################################");
    }
}
