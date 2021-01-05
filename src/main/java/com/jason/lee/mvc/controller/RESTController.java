package com.jason.lee.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/14
 */
@Controller
public class RESTController {

    /**
     * 查询
     */
    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") int id) {
        System.out.println("GET: " + id);
        return "success";  //视图名
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/testREST", method = RequestMethod.POST)
    public String insertUser() {
        System.out.println("POST");
        return "success";  //视图名
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/testREST", method = RequestMethod.PUT)
    public String updateUser() {
        System.out.println("PUT");
        return "put";
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") int id) {
        System.out.println("DELETE: " + id);
    }

    @RequestMapping(value = "/testAjax", method = RequestMethod.GET)
    public void testAjax(int id, HttpServletResponse response) throws IOException {
        response.getWriter().write("success");
        System.out.println("Ajax GET: " + id);
    }
}
