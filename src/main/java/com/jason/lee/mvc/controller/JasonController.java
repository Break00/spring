package com.jason.lee.mvc.controller;

import com.jason.lee.mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description:
 * @Author: Json Lee
 * @Date: 2020/10/28 9:52 PM
 */
@Controller
public class JasonController {


    @ResponseBody  //
    @RequestMapping(value = "/testJason")
    public List<User> testJason(){
        ArrayList<User> list = new ArrayList<>();
        User user = new User("李奂", "123456");
        list.add(user);
        list.add(user);
        list.add(user);
        return list;
    }
}
