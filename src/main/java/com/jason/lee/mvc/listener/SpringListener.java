package com.jason.lee.mvc.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Jason Lee
 * @description
 * @date 2020/11/8 11:37 上午
 */

public class SpringListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public SpringListener() {
        System.out.println("SpringListener");
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        ApplicationContext ac = new  ClassPathXmlApplicationContext("springTest.xml");
        sce.getServletContext().setAttribute("ac", ac);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

}
