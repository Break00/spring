package com.jason.lee.annotation.bean;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 17:05
 */
public class Car {

    public Car() {
        System.out.println("Car...");
    }

    public void init(){
        System.out.println("Car init...");
    }

    public void destroy(){
        System.out.println("Car destroy...");
    }
}
