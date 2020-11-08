package com.jason.lee.mvc.pojo;

/**
 * @author Jason Lee
 * @description
 * @date 2020/11/8 11:43 上午
 */
public class Entity {
    private String name;
    private int age;

    public Entity() {
        System.out.println("Entity");
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

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
