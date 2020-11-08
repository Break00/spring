package com.jason.lee.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @Description:
 * @Author: Json Lee
 * @Date: 2020/10/28 9:52 PM
 */
@Controller
public class TestExceptionController {


    @RequestMapping(value = "/testException", method = RequestMethod.GET)
    public String testJason() {
        String s = null;
        s.length();
        return "success";
    }
}
