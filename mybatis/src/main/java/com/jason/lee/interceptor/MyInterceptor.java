package com.jason.lee.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author huanli9
 * @description
 * @date 2020/12/16 22:34
 */
// 插件签名（拦截哪个对象的哪个方法）
@Intercepts({@Signature(type= StatementHandler.class ,method = "prepare" ,args = {Connection.class,Integer.class})})
public class MyInterceptor  implements Interceptor {

    /*拦截目标对象的目标方法*/
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 执行目标方法
        Object result = invocation.proceed();
        System.out.println("============Invocation.proceed()============");
        return result;
    }

    /*包装目标对象，为目标对象创建一个代理对象*/
    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    /*设置插件的配置信息*/
    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties.getProperty("key"));
    }
}
