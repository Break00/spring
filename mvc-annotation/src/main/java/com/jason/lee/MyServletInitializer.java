package com.jason.lee;

import com.jason.lee.config.AppConfig;
import com.jason.lee.config.RootConfig;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author huanli9
 * @description
 * @date 2020/11/30 9:58
 */
// Servlet容器启动创建的时候创建对象，调用方法初始化容器以及前端控制器
public class MyServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 获取根容器的配置类（Spring的配置文件）——父容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    // 获取web容器的配置类（SpringMVC的配置文件）——子容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    // 获取DispatcherServlet的映射信息
    @Override
    protected String[] getServletMappings() {
        // /——拦截所有请求（包括静态资源（xx.js，xx.png），不包括*.jsp）
        // /*——拦截所有请求，包括*.jsp页面，jsp页面是tomcat的jsp引擎解析的
        return new String[]{"/"};
    }
}
