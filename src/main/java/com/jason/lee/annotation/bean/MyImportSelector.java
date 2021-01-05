package com.jason.lee.annotation.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author huanli9
 * @description
 * @date 2020/11/14 16:28
 */
// 自定义需要导入的组件
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值就是导入容器的组件全类名
     * @param annotationMetadata 当前标注@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.jason.lee.annotation.bean.Teacher"};
    }
}
