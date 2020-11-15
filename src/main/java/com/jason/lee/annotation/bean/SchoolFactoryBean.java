package com.jason.lee.annotation.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 16:50
 */
public class SchoolFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        System.out.println("SchoolFactoryBean......");
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    // 是否单实例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
