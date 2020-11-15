package com.jason.lee.annotation.test;

import com.jason.lee.annotation.bean.People;
import com.jason.lee.annotation.config.LifeCycleConfig;
import com.jason.lee.annotation.config.PropertyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 19:22
 */
public class PropertyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyConfig.class);
//        String[] names = applicationContext.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
        People people = applicationContext.getBean("people", People.class);
        System.out.println(people);
        applicationContext.close();
    }
}
