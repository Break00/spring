package com.jason.lee.annotation.test;

import com.jason.lee.annotation.config.LifeCycleConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 17:07
 */
public class LifeCycleTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        applicationContext.close();
    }
}
