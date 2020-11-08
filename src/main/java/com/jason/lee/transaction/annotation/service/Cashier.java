package com.jason.lee.transaction.annotation.service;

import java.util.List;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/12
 */
public interface Cashier {

    void checkOut(String uid, List<String> bids);
}
