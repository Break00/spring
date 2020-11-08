package com.jason.lee.aop.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/9
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-xml.xml");
        MathIntf math = (MathIntf)ac.getBean("mathImpl");
        math.add(1, 2);
    }
}
