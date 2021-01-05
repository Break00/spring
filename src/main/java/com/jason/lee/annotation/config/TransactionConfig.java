package com.jason.lee.annotation.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author huanli9
 * @description
 * @date 2020/11/19 20:21
 */
@EnableTransactionManagement   // 开启基于注解的事务管理功能
@ComponentScan("com.jason.lee.annotation.transaction")
@PropertySource("classpath:db.properties")
@Configuration
public class TransactionConfig {
    @Value("${jdbc.username}")
    private String user;

    @Value("${jdbc.driver}")
    private String driver;

    @Bean
    public DataSource dataSourceTest(@Value("${jdbc.password}") String pwd) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(pwd);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/local");
        return druidDataSource;
    }

    // 从Spring容器中注入DataSource
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    // 注册事务管理器
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
