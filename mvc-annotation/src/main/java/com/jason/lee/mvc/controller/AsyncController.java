package com.jason.lee.mvc.controller;


import com.jason.lee.service.DeferredResultQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * @author huanli9
 * @description
 * @date 2020/11/30 14:48
 */
@Controller
public class AsyncController {

    /**
     * 1、控制器返回Callable
     * 2、SpringMVC异步处理，将 Callable 提交到 TaskExecutor，使用一个隔离线程执行
     * 3、DispatcherServlet 和所有 Filter 退出容器的线程
     * 4、Callable返回结果，SpringMVC将请求重新派发给容器
     * 5、根据Callable返回结果，SpringMVC进行视图渲染等流程
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/async1")
    public Callable<String> async1() {
        System.out.println("main thread: " + Thread.currentThread().getName() + " start...");
        Callable<String> callable = new Callable<String>() {
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " start...");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " end...");
                return "Callable<String> async1()";
            }
        };
        System.out.println("main thread: " + Thread.currentThread().getName() + " end...");
        return callable;
    }

    @ResponseBody
    @RequestMapping("/async2")
    public DeferredResult<Object> async2() {
        DeferredResult<Object> deferredResult = new DeferredResult<>(3000l, "fail");
        DeferredResultQueue.save(deferredResult);
        return deferredResult;
    }

    @ResponseBody
    @RequestMapping("/create")
    public String create() {
        String order = UUID.randomUUID().toString();
        DeferredResult<Object> deferredResult = DeferredResultQueue.get();
        deferredResult.setResult(order);
        return "success: " + order;
    }
}
