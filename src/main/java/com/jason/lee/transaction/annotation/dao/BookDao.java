package com.jason.lee.transaction.annotation.dao;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/12
 */
public interface BookDao {

    int selectPrice(String  bid);

    void updateSt(String bid);

    void updateBalance(String uid,int price);

}
