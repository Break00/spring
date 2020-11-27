package com.jason.lee.transaction.annotation.service.impl;

import com.jason.lee.transaction.annotation.dao.BookDao;
import com.jason.lee.transaction.annotation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * @param bid
     * @param uid
     * @Transactional 可以设置的属性：
     * propagation：A方法 和 B方法都有事务, A调用B时会将A中的事务传播给B, B方法对于事务的处理行为就是事务的传播行为
     *      Propagation.REQUIRED：必须使用调用者的事务 【默认】
     *      Propagation.REQUIRES_NEW：将调用者的事务挂起, 使用新的事务
     * isolation：
     *      读未提交, 脏读
     *      读已提交, 不可重复读
     *      可重复读  【MySQL默认隔离级别】
     *      串行化
     * timeout：强制回滚之前可以等待的时间
     * readOnly：指定当前事务中的操作是否只读, 数据库不加锁
     * rollbackFor|rollbackForClassName|noRollbackFor|noRollbackForClassName  回滚
     *
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 3, readOnly = false)  //仅对注解方法生效
    @Override
    public void buyBook(String bid, String uid) {
        Integer price = dao.selectPrice(bid);
        dao.updateSt(bid);
        dao.updateBalance(uid, price);
    }
}
