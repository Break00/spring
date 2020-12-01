package com.jason.lee.annotation.web;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author huanli9
 * @description
 * @date 2020/11/27 20:49
 */
// 容器启动时会将@HandlesTypes指定的类型下所有的子类（实现类、子接口）传递过来
@HandlesTypes(value = {HelloService.class}) //传入感兴趣的类型
public class MyServletContainerInitializer implements ServletContainerInitializer {

    // 应用启动时运行onStartup方法

    /**
     * @param c   感兴趣的类型的所有子类型
     * @param ctx 代表当前web应用的ServletContext，每个web应用对应一个ServletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("感兴趣的类型：");
        c.stream().forEach(System.out::println);

        //注册三大组件
        ServletRegistration.Dynamic servlet = ctx.addServlet("helloServlet", new HelloServlet());
        servlet.addMapping("/hi");

        ctx.addListener(HelloListener.class);

        FilterRegistration.Dynamic filter = ctx.addFilter("helloFilter", HelloFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
    }
}
