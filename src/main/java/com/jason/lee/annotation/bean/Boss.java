package com.jason.lee.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 20:05
 */
//默认加载IOC容器中的组件，容器启动时会调用无参构造器创建对象，再进行初始化赋值等操作
public class Boss {

    private Car car;

//   默认调用无参构造器
//    public Boss() {
//    }

    //    @Autowired //方法参数为Spring容器中的Bean
    public Boss(@Autowired Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    //    @Autowired //标注在方法上，Spring容器创建当前对象时，就会调用方法完成赋值，方法参数为Spring容器中的Bean
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
