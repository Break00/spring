package com.jason.lee.annotation.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 17:06
 */
//@Profile("test")  // 该配置类只有在test下才生效
@PropertySource("classpath:db.properties")
@Configuration
public class ProfileConfig implements EmbeddedValueResolverAware {

    @Value("${jdbc.username}")
    private String user;

    private String driver;

    @Profile("test")
    @Bean
    public DataSource dataSourceTest(@Value("${jdbc.password}") String pwd) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setPassword(pwd);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        return druidDataSource;
    }

    @Profile("dev")
    @Bean
    public DataSource dataSourceDev(@Value("${jdbc.password}") String pwd) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(user);
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/dev");
        druidDataSource.setPassword(pwd);
        druidDataSource.setDriverClassName(driver);
        return druidDataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.driver = resolver.resolveStringValue("${jdbc.driver}");
    }
}
