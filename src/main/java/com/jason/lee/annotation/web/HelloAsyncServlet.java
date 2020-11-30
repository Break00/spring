package com.jason.lee.annotation.web;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huanli9
 * @description Servlet3.0 提供的异步处理机制
 * @date 2020/11/30 14:19
 */
@WebServlet(value = "/async", asyncSupported = true)  // 1、开启支持异步处理
public class HelloAsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("main thread: " + Thread.currentThread().getName() + " start...");
        // 2、开启异步模式
        AsyncContext asyncContext = req.startAsync();

        // 3、业务逻辑处理
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " start...");
                    doSomething();
                    asyncContext.complete();
                    ServletResponse response = asyncContext.getResponse();
                    response.getWriter().write("hello async");
                    System.out.println(Thread.currentThread().getName() + " end...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("main thread: " + Thread.currentThread().getName() + " end...");
    }

    private void doSomething() throws InterruptedException {
        Thread.sleep(3000);
    }
}
