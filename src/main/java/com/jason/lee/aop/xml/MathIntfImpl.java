package com.jason.lee.aop.xml;

import org.springframework.stereotype.Component;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/9
 */
@Component("mathImpl")
public class MathIntfImpl implements MathIntf {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println(result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        return i/j;
    }
}
