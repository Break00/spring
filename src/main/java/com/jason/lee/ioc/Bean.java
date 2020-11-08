package com.jason.lee.ioc;

import org.springframework.stereotype.Component;


/**
 * @author 19047589 Jason Lee
 * @description  bean默认的id: ioc  [类名的首字母小写]
 * @date 2020/10/1
 */
@Component
public class Bean {

    @Override
    public String toString() {
        return "Bean to String";
    }
}
