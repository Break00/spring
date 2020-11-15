package com.jason.lee.annotation.bean;


import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 18:29
 */
public class Bike {

    private int price;

    public Bike() {
        System.out.println("Bike...");
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Bike  @PostConstruct...");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Bike  @PreDestroy...");
    }

    public int getPrice() {
        return price;
    }

    @Value("1000")
    public void setPrice(int price) {
        System.out.println("bike price...");
        this.price = price;
    }
}
