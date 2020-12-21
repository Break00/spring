package com.jason.lee.mbg.dao;

import com.jason.lee.mbg.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}