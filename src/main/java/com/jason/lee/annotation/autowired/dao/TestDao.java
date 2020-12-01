package com.jason.lee.annotation.autowired.dao;

import com.jason.lee.annotation.bean.People;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * @author huanli9
 * @description
 * @date 2020/11/14 14:21
 */
@Repository
public class TestDao {

    @Inject
    public People people;

}
