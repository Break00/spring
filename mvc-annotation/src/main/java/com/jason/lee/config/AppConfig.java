package com.jason.lee.config;


import com.jason.lee.mvc.interceptor.FirstInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author huanli9
 * @description
 * @date 2020/11/30 10:20
 */
// SpringMVC容器
@ComponentScan(value = "com.jason.lee",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
        useDefaultFilters = false) // 禁用默认配置规则
@EnableWebMvc  //相当于<mvc:annotation-driven/>
public class AppConfig extends WebMvcConfigurerAdapter {

    // 视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    // 静态资源访问
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FirstInterceptor()).addPathPatterns("/**");
    }
}
