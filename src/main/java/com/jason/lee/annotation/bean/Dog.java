package com.jason.lee.annotation.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 17:18
 */
public class Dog implements InitializingBean, DisposableBean {

    public Dog() {
        System.out.println("Dog...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Dog afterPropertiesSet...");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("Dog destroy...");
    }

}
