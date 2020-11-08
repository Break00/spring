package com.jason.lee.transaction.xml.service.impl;

import com.jason.lee.transaction.xml.dao.BookDao;
import com.jason.lee.transaction.xml.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/12
 */
@Service
//@Transactional  对注解类下的所有方法生效
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao dao;

    @Override
    public void buyBook(String bid, String uid) {
        Integer price = dao.selectPrice(bid);
        dao.updateSt(bid);
        dao.updateBalance(uid, price);
    }
}
