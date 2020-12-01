package com.jason.lee.annotation.test;

import com.jason.lee.annotation.config.ExtConfig;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huanli9
 * @description
 * @date 2020/11/16
 */
public class ExtTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")){});
        applicationContext.close();
    }
}
