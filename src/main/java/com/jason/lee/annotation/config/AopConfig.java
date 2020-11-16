package com.jason.lee.annotation.config;

import com.jason.lee.annotation.aop.LogAspects;
import com.jason.lee.annotation.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author huanli9
 * @description
 * @date 2020/11/16 7:45
 */
@EnableAspectJAutoProxy //开启基于注解的AOP模式
@Configuration
public class AopConfig {

    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
