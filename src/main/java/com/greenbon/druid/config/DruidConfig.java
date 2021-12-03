package com.greenbon.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;

import javax.activation.DataSource;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DruidConfig {
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource druidDataSource(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        return (DataSource) new DruidDataSource();
//    }
@Configuration
public class DruidDBConfig {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.druid.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.druid.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.druid.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.druid.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.maxEvictableIdleTimeMillis}")
    private int maxEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.druid.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.druid.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.druid.testOnReturn}")
    private boolean testOnReturn;

//    @Value("${spring.datasource.druid.poolPreparedStatements}")
//    private boolean poolPreparedStatements;

//    @Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
//    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("{spring.datasource.druid.connectionProperties}")
    private String connectionProperties;
//    @Value("${spring.datasource.druid.filters}")
//    private String filters;

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DruidDataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setConnectionProperties(connectionProperties);
        try {
//            datasource.setFilters(filters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datasource;
    }
}

//    @Value("${spring.datasource.url}")
//    String url;
//
//    @Value("${spring.datasource.username}")
//    String username;
//
//    @Value("${spring.datasource.password}")
//    String password;
//
//    @Value("${spring.datasource.driver-class-name}")
//    String driverClassName;
//
//    @Bean("dataSource")
//    public DataSource druidDataSource(StandardEnvironment env) {
//        Properties properties = new Properties();
//        DruidDataSource druidDataSource = new DruidDataSource();
//        PropertySource<?> appProperties = env.getPropertySources().get("applicationConfig: [classpath:/application.yml]");
//        Map<String,Object> source = (Map<String, Object>) appProperties.getSource();
//        properties.putAll(source);
//        druidDataSource.configFromPropety(properties);
//        druidDataSource.setUrl(url);
//        druidDataSource.setPassword(username);
//        druidDataSource.setUsername(password);
//        druidDataSource.setDriverClassName(driverClassName);
//        return (DataSource) druidDataSource;
//    }
}
