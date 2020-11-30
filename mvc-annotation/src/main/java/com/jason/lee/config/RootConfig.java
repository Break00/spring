package com.jason.lee.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author huanli9
 * @description
 * @date 2020/11/30 10:20
 */
// Spring容器
@ComponentScan(value = "com.jason.lee",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class))
public class RootConfig {
}
