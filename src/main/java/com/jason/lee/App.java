package com.jason.lee;

import com.jason.lee.ioc.MyBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // 获取容器 ApplicationContext
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
//        MyBean test03 = ac.getBean("test03", MyBean.class);
//        Example example04 = ac.getBean("example04", Example.class);
//        Example example05 = ac.getBean("example05", Example.class);
//        Example example01 = ac.getBean("example01", Example.class);
//        Object myFactory = ac.getBean("myFactory");
//        System.out.println(test03);
//        System.out.println(example04);
//        System.out.println(example05);
//        System.out.println(myFactory);
//        System.out.println(example01);
//        ac.close();

//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
//        DruidDataSource dataSource = ac.getBean("dataSource", DruidDataSource.class);
//        System.out.println(dataSource);

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        MyBean aBean = ac.getBean("test03", MyBean.class);
        System.out.println(aBean);

    }
}
