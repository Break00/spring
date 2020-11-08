package com.jason.lee.transaction.xml.controller;

import com.jason.lee.transaction.xml.service.BookService;
import com.jason.lee.transaction.xml.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/12
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private Cashier cashier;

    public void buyBook() {
        bookService.buyBook("1", "1001");
    }

    public void checkOut() {
        List<String> bids = new ArrayList<>();
        bids.add("1");
        bids.add("2");
        cashier.checkOut("1001", bids);
    }

}
