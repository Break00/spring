package com.jason.lee.mapper;

import com.jason.lee.entity.User;

import java.util.List;

/**
 * @author huanli9
 * @description
 * @date 2020/12/14 14:27
 */
public interface DynamicSQLMapper {

    List<User> getUser(User user);

    List<User> getUserLike(String name);
}
