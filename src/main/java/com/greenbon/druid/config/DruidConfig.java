package com.greenbon.druid.config;

import com.greenbon.sharding.enums.ShardingType;
import com.greenbon.sharding.factory.YamlDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
@Configuration
public class DruidConfig {

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DataSource datasource = null;
        try {
            datasource = YamlDataSourceFactory.newInstance(ShardingType.MONTH_SHARDING_TABLES);
//            datasource = YamlDataSourceFactory.newInstance(ShardingType.MOD_SHARDING_TABLES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datasource;
    }
}

