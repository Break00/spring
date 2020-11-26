package com.jason.lee.annotation.config;

import com.jason.lee.annotation.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author huanli9
 * @description
 * @date 2020/11/16 7:45
 *
 */
@ComponentScan("com.jason.lee.annotation.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Car car(){
        return new Car();
    }
}
