package com.jason.lee.aop.annotation;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author 19047589 Jason Lee
 * @description  自定义实现JDK动态代理
 * @date 2020/10/9
 */
public class ProxyUtil {
    private MathIntf mathIntfImpl;

    public ProxyUtil(MathIntf mathIntfImpl) {
        this.mathIntfImpl = mathIntfImpl;
    }

    public Object getProxy(){
        ClassLoader loader = this.getClass().getClassLoader();
        Class[] interfaces = mathIntfImpl.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader, interfaces, (proxy,method,args)-> {
            MyLogger.before(method.getName(), Arrays.toString(args));
            Object result = method.invoke(mathIntfImpl,args);
            MyLogger.after(method.getName(),result);
            return result;
        });
    }
}
