package com.jason.lee.annotation.autowired.controller;

import com.jason.lee.annotation.autowired.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author huanli9
 * @description
 * @date 2020/11/14 14:20
 */
@Controller
public class TestController {

    // 自动注入，存在多个类型相同的组件时，以testService为id去装配
    @Autowired(required = false)
    private TestService testService;

    public void print(){
        System.out.println(testService);
    }

}
