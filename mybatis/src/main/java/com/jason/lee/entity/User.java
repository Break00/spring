package com.jason.lee.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author huanli9
 * @description  数据库表对应的实体类
 * @date 2020/12/14 9:12
 */
@Alias("user")
@Data
public class User {
    private int id;
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
