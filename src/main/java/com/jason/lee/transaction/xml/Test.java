package com.jason.lee.transaction.xml;


import com.jason.lee.transaction.xml.controller.BookController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/12
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-transaction-xml.xml");
        BookController controller = ac.getBean("bookController", BookController.class);
        // controller.buyBook();
        controller.checkOut();
    }
}
