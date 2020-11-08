package com.jason.lee.mvc.controller;

import com.jason.lee.mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/14
 */
@Controller
public class ParamController {

    /**
     * 在SpringMVC中获取客户端传递数据：
     *      1、在处理请求的方法中使用的参数名和传递数据的参数名保持一致  自动赋值
     *      2、@RequestParam (value = "name") 指定参数的映射关系
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/param1", method = RequestMethod.POST)
    public String testParam(@RequestParam(value = "name", required = false, defaultValue = "admin") String username,
                            String password,
                            @RequestHeader("Accept-Language") String acceptLanguage,
                            @CookieValue("JSESSIONID") String cookie) {
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("header: " + acceptLanguage);
        System.out.println("cookie: " + cookie);
        return "success";  //视图名
    }

    /**
     * POJO接收参数属性名和表单name属性名一致  支持级联
     * @param user
     * @return
     */
    @RequestMapping(value = "/param2", method = RequestMethod.POST)
    public String testPOJOParam(User user) {
        System.out.println(user);
        return "success";  //视图名
    }

    /**
     * MVC的Handler方法可以接收哪些ServletAPI类型的参数：
     *      HttpServletRequest
     *      HttpServletResponse
     *      HttpSession
     *      Principle
     *      Locale
     *      InputStream
     *      OutputStream
     *      Reader
     *      Writer
     * @return
     */
    @RequestMapping(value = "/param3", method = RequestMethod.POST)
    public String testServletApi(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        String name = request.getParameter("username");
        request.setAttribute("username",name);
        System.out.println(name);
        return "success";  //视图名
    }

    /**
     * 一、使用ModelAndView向作用域设值
     * @return
     */
    @RequestMapping(value = "/setValue1")
    public ModelAndView setValue1(){
        ModelAndView mv = new ModelAndView();
        //设置数据至request域
        mv.addObject("username", "admin");
        //设置视图
        mv.setViewName("success");
        return mv;
    }

    /**
     * 二、使用Map向作用域设值
     * @param map
     * @return
     */
    @RequestMapping(value = "/setValue2")
    public String  setValue2(Map<String,Object> map){
        map.put("username", "root");
        return "success";
    }

    /**
     * 三、使用Model向作用域设值
     * @param model
     * @return
     */
    @RequestMapping(value = "/setValue3")
    public String  setValue3(Model model){
        model.addAttribute("username", "username");
        return "success";
    }

    /**
     * 四、使用HttpServletRequest向作用域设值
     * @param request
     * @return
     */
    @RequestMapping(value = "/setValue4")
    public String  setValue4(HttpServletRequest request){
        request.setAttribute("username","password");
        return "success";
    }

}


















