package com.jason.lee.ioc;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/1
 */
public class Test {
    private int id;
    private String name;
    private Example example;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                example.toString();
    }
}
