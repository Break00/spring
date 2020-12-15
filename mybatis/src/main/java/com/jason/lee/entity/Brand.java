package com.jason.lee.entity;

import lombok.Data;

import java.util.List;

/**
 * @author huanli9
 * @description
 * @date 2020/12/15 14:56
 */
@Data
public class Brand {

    private int id;
    private String name;
    private List<Product> products;
}
