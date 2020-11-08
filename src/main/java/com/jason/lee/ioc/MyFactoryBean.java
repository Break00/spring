package com.jason.lee.ioc;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/1
 */
public class MyFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand("BMW");
        car.setPrice(2000000D);
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
