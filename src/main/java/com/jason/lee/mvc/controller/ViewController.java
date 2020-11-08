package com.jason.lee.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Json Lee
 * @Date: 2020/10/25 11:11 PM
 */
@Controller
public class ViewController {
    /**
     * View类型：
     *      InternalResourceView  转发视图
     *      JstlView  转发视图 （jstl标签）
     *      RedirectView  重定向视图
     * @param
     * @return
     */
    @RequestMapping(value = "/testView1")
    public String testView1() {
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/testView2")
    public String testView2() {
        // WEB-INF/view/index.jsp
        return "index";
    }
}
