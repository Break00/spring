package com.jason.lee.annotation.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 20:26
 */
public class Bean implements ApplicationContextAware, BeanNameAware {

    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        System.out.println("当前Bean的名字：" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("IOC容器：" + applicationContext);
        this.applicationContext = applicationContext;
    }
}
