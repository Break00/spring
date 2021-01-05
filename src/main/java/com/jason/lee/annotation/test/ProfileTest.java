package com.jason.lee.annotation.test;

import com.jason.lee.annotation.config.ProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 19:40
 */
public class ProfileTest {

    public static void main(String[] args) {
        // 创建上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 设置激活环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        // 注册主配置类
        applicationContext.register(ProfileConfig.class);
        // 启动刷新容器
        applicationContext.refresh();

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        CollectionUtils.arrayToList(namesForType).stream().forEach(System.out::println);

        applicationContext.close();
    }
}
