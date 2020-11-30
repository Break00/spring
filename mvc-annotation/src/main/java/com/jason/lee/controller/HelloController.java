package com.jason.lee.controller;


import com.jason.lee.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huanli9
 * @description
 * @date 2020/11/30 10:26
 */
@Controller
public class HelloController {

    @Autowired
    HelloService service;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return service.sayHello("Tomcat");
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
