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
@Intercepts({@Signature(type= StatementHandler.class ,method = "prepare" ,args = {Connection.class,Integer.class})})
public class MyInterceptor  implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object result = invocation.proceed();
        System.out.println("============Invocation.proceed()============");
        return result;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
