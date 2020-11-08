package com.jason.lee.aop.xml;

import org.springframework.stereotype.Component;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/9
 */
@Component
public class MyLogger {
    public static void before() {
        System.out.println("前置通知");
    }

    public static void after() {
        System.out.println("后置置通知");
    }
}
