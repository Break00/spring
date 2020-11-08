package com.jason.lee.transaction.xml.dao.impl;

import com.jason.lee.transaction.xml.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/12
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public int selectPrice(String bid) {
        return template.queryForObject("select price from book where bid = ?", new Object[]{bid}, Integer.class);
    }

    @Override
    public void updateSt(String sid) {
        Integer st = template.queryForObject("select st from stock where sid = ? ", new Object[]{sid}, Integer.class);
        if (st <= 0) {
            throw new RuntimeException();
        } else {
            template.update("UPDATE stock SET st = st-1 WHERE sid = ?", sid);
        }
    }

    @Override
    public void updateBalance(String uid, int price) {
        Integer balance = template.queryForObject("select balance from money where uid = ? ", new Object[]{uid}, Integer.class);
        if (balance < price) {
            throw new RuntimeException();
        } else {
            template.update("UPDATE money SET balance = balance-? where uid = ?", price, uid);
        }
    }
}
