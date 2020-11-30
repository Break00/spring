package com.jason.lee.annotation.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author huanli9
 * @description
 * @date 2020/11/30 8:35
 */
public class HelloListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("HelloListener...contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("HelloListener...contextDestroyed");
    }
}
