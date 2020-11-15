package com.jason.lee.annotation.bean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 16:39
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @param registry               自定义注册Bean
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean stuDef = registry.containsBeanDefinition("com.jason.lee.annotation.bean.Student");
        boolean tehDef = registry.containsBeanDefinition("com.jason.lee.annotation.bean.Teacher");

        if (stuDef && tehDef) {
            // 自定义Bean信息
            RootBeanDefinition beanDefinition = new RootBeanDefinition(School.class);
            registry.registerBeanDefinition("school", beanDefinition);
        }
    }
}
