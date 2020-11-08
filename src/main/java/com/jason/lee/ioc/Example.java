package com.jason.lee.ioc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/1
 */
public class Example {
    private int id;
    private String name;
    private List<Integer> list;
    private int[] array;
    private HashMap<String,String> map;

    public Example() {
    }

    public Example(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public void init(){
        System.out.println("init");
    }

    public void destroy(){
        System.out.println("destroy");
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                ", array=" + Arrays.toString(array) +
                ", map=" + map +
                '}';
    }
}
