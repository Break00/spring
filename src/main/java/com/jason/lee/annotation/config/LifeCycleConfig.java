package com.jason.lee.annotation.config;

import com.jason.lee.annotation.bean.Bike;
import com.jason.lee.annotation.bean.Car;
import com.jason.lee.annotation.bean.Dog;
import com.jason.lee.annotation.bean.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author huanli9
 * @description
 * @date 2020/11/15 17:06
 */
@Configuration
public class LifeCycleConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

    @Bean
    public Dog dog() {
        return new Dog();
    }

    @Bean
    public Bike bike() {
        return new Bike();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }
}
