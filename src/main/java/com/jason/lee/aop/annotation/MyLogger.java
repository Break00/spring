package com.jason.lee.aop.annotation;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/9
 */
public class MyLogger {
    public static void before(String methodName, String args) {
        System.out.println("methodName: " + methodName + "——args：" + args);
    }

    public static void after(String methodName, Object result) {
        System.out.println("methodName: " + methodName + "——result：" + result);
    }
}
