package com.jason.lee.mvc.controller;

import com.jason.lee.mvc.pojo.Entity;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * @author Jason Lee
 * @description
 * @date 2020/11/8 12:27 下午
 */
@Controller
public class TestListener {

    /**
     * Spring 与 SpringMVC 整合
     *      Spring 管理业务类
     *      SpringMVC 管理控制器
     * 首先在 web.xml 中配置 listener 和 servlet，listener加载Spring容器并将容器设置到ServletContext中，
     * servlet加载SpringMVC容器，SpringMVC并从ServletContext中获取Spring容器从而获得容器中配置的业务Bean
     *
     * #### 无返回值时，默认以@RequestMapping中的值获取视图 即TestListener.jsp ####
     * @param session
     */
    @RequestMapping("TestListener")
    public void testListener(HttpSession session){
        ServletContext sc = session.getServletContext();
        ApplicationContext ac = (ApplicationContext)sc.getAttribute("ac");
        Entity entity = ac.getBean("entity", Entity.class);
        System.out.println(entity);
    }
}
