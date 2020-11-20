package com.jason.lee.annotation.test;

import com.jason.lee.annotation.config.TransactionConfig;
import com.jason.lee.annotation.transaction.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huanli9
 * @description
 * @date 2020/11/19 20:38
 */
public class  TransactionTest {
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);

    public static void main(String[] args) {
        TestService testService = applicationContext.getBean("testService", TestService.class);
        testService.insert();
    }
}
