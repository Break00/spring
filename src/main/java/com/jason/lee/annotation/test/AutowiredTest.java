package com.jason.lee.annotation.test;

import com.jason.lee.annotation.bean.Boss;
import com.jason.lee.annotation.bean.Car;
import com.jason.lee.annotation.config.AutowiredConfig;
import com.jason.lee.annotation.controller.TestController;
import com.jason.lee.annotation.dao.TestDao;
import com.jason.lee.annotation.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huanli9
 * @description
 * @date 2020/11/15 19:40
 */
public class AutowiredTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        System.out.println(applicationContext);

        TestController controller = applicationContext.getBean(TestController.class);
        controller.print();

        TestService service = applicationContext.getBean(TestService.class);
        System.out.println(service);

        TestDao dao = applicationContext.getBean(TestDao.class);
        System.out.println(dao.people);

        Boss boss = applicationContext.getBean(Boss.class);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(boss);
        System.out.println(car);

    }
}
