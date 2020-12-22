package com.jason.lee.mapper;

import com.jason.lee.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById(int id);

    User getUserByIdAndName(@Param("id") int id, @Param("name") String name);

    List<User> getUsersByName(String name);

    Map<String, Object> getUserMapById(int id);

    @MapKey("id")  // 封装map时指定map的key
    Map<String, User> getUserMapsByName(String name);

    // mybatis允许增删改直接定义以下返回类型
    // Integer、Long、Boolean、void
    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    List<User> selectAll();
}
