package com.jason.lee.annotation.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huanli9
 * @description
 * @date 2020/11/27 17:30
 */
//@WebServlet("/hi")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(Thread.currentThread().getName()+" start...");
        response.getWriter().write("hi");
        System.out.println(Thread.currentThread().getName()+" end...");
    }

    private void doSomething() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" processing...");
        Thread.sleep(3000);
    }
}
