package com.jason.lee.entity;

import lombok.Data;

/**
 * @author huanli9
 * @description
 * @date 2020/12/14 14:28
 */
@Data
public class Product {

    private int id;
    private String name;
    private Brand brand;

    public Product() {
    }

    public Product(int id, String name, Brand brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public Product(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
    }

    public Product(String name) {
        this.name = name;
    }
}
