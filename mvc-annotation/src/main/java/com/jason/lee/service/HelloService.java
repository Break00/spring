package com.jason.lee.service;

import org.springframework.stereotype.Service;

/**
 * @author huanli9
 * @description
 * @date 2020/11/30 10:27
 */
@Service
public class HelloService {

    public String sayHello(String name){
        return name + " ,hello!";
    }
}
