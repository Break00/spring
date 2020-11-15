package com.jason.lee.annotation.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author huanli9
 * @description
 * @date 2020/11/14 14:11
 */
public class People {

    @Value("lee")
    private String name;

    // SPEL表达式
    @Value("${people.nickName}")
    private String nickName;

    @Value("#{20-2}")
    private int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                '}';
    }
}
