package com.jason.lee.annotation.config;

import com.jason.lee.annotation.bean.Bean;
import com.jason.lee.annotation.bean.Boss;
import com.jason.lee.annotation.bean.Car;
import com.jason.lee.annotation.bean.People;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 19:38
 */
@Configuration
@PropertySource("classpath:people.properties")
@Import({People.class, Car.class, Boss.class, Bean.class})
@ComponentScan({"com.jason.lee.annotation.autowired"})
public class AutowiredConfig {
}
