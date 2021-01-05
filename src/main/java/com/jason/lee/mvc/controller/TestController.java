package com.jason.lee.mvc.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/13
 */
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("hello")
    public String hello() {
        System.out.println("success");
        return "success";  //视图名
    }

    /**
     * value   设置请求路径
     * method  设置请求方式
     * params  设置请求路径中包含的参数
     * headers 设置请求头
     * @return
     */
    @ApiOperation(value="一个测试API",notes = "第一个测试api")
    @RequestMapping(value = "/testGet", method = RequestMethod.GET, params = {"!user"},headers = {"Connection=keep-alive"})
    public String testGet() {
        System.out.println("success");
        return "success";  //视图名
    }

    /**
     * springMVC支持Ant风格路径：
     *      * 任意个字符
     *      ? 单个字符
     *      ** 任意多层路径
     * @return
     */
    @RequestMapping(value = "/*/test", method = RequestMethod.POST)
    public String testPost() {
        System.out.println("success");
        return "success";  //视图名
    }

    /**
     * 获取路径参数localhost:8080/test1?id=1001
     * @return
     */
    @RequestMapping(value = "/test1")
    public String testParam1(int id) {
        System.out.println(id);
        return "success";  //视图名
    }

    /**
     * 获取路径参数localhost:8080/test2?id=1001
     * @return
     */
    @RequestMapping(value = "/test2")
    public String testParam2(HttpServletRequest request) {
        String  id = request.getParameter("id");
        System.out.println(id);
        return "success";  //视图名
    }

    /**
     * 获取路径参数localhost:8080/test3/1001
     * @param id
     * @return
     */
    @RequestMapping(value = "/test3/{id}")
    public String testParam3(@PathVariable("id") int id) {
        System.out.println(id);
        return "success";  //视图名
    }
}
