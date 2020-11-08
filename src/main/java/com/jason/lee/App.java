package com.jason.lee;

import com.jason.lee.ioc.Bean;
import com.jason.lee.ioc.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // 获取容器 ApplicationContext
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-bean.xml");
//        Test test03 = ac.getBean("test03", Test.class);
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

//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("dataSource.xml");
//        DruidDataSource dataSource = ac.getBean("dataSource", DruidDataSource.class);
//        System.out.println(dataSource);

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-bean.xml");
        Employee employee = ac.getBean("employee", Employee.class);
        Bean bean = ac.getBean(Bean.class);
        System.out.println(employee);
        System.out.println(bean);
        String s = new String();
    }
}
