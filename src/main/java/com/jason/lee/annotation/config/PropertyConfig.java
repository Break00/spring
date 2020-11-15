package com.jason.lee.annotation.config;

import com.jason.lee.annotation.bean.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 19:21
 */
@PropertySource("classpath:people.properties")  // 加载配置文件
@Configuration
public class PropertyConfig {

    @Bean
    public People people() {
        return new People();
    }
}
