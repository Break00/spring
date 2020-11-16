package com.jason.lee.annotation.test;

import com.jason.lee.annotation.aop.MathCalculator;
import com.jason.lee.annotation.config.AopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huanli9
 * @description
 * @date 2020/11/16
 *  1、传入配置类，创建IOC容器
 *  2、注册配置类，刷新容器 refresh()
 *  3、注册后置处理器
 *  4、应用后置处理器
 */
public class AopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(5, 2);
    }
}
