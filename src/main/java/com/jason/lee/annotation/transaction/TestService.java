package com.jason.lee.annotation.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huanli9
 * @description
 * @date 2020/11/19 20:27
 */
@Service
public class TestService {

    @Autowired
    private TestDao dao;

    @Transactional
    public void insert() {
        dao.insert();
//        int num = 10 / 0;
    }
}
