package com.jason.lee.transaction.xml.service.impl;

import com.jason.lee.transaction.xml.service.BookService;
import com.jason.lee.transaction.xml.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/12
 */
@Service
public class CashierImpl implements Cashier {

    @Autowired
    private BookService service;

    @Override
    public void checkOut(String uid, List<String> bids) {
        for (String bid : bids) {
            service.buyBook(bid, uid);
        }
    }
}
