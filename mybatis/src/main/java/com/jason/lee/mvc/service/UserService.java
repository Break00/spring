package com.jason.lee.mvc.service;

import com.jason.lee.entity.User;
import com.jason.lee.mvc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanli9
 * @description
 * @date 2020/12/17 17:19
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers(){
        return userMapper.getUsers();
    }
}
