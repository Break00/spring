package com.jason.lee.mvc.controller;

import com.jason.lee.entity.User;
import com.jason.lee.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * @author huanli9
 * @description
 * @date 2020/12/17 17:14
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "list";
    }
}
