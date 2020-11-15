package com.jason.lee.annotation.service;

import com.jason.lee.annotation.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huanli9
 * @description
 * @date 2020/11/14 14:21
 */
@Service
public class TestService {

    @Resource
    private TestDao testDao;
}
