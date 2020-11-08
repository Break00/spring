package com.jason.lee.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 19047589 Jason Lee
 * @description
 * @date 2020/10/10
 */
@Component
@Aspect  //标注当前类为切面
@Order(value = 1)  //定义切面作用的优先级 【值越小优先级越高】
public class MyAspect {


    //定义公共切入点
    @Pointcut(value = "execution(* com.jason.lee.aop.annotation.*.*(..))")
    public void pointCut(){}


    /**
     * @Before 将方法指定为前置通知  【方法执行前】
     * 必须设置value,其值为切入点表达式(定位被作用的位置——连接点)
     * joinPoint 获取连接点信息
     */
    //@Before(value = "execution(public int com.jason.lee.aop.annotation.MathIntfImpl.add(int,int))")
    //   *    com.jason.lee.aop.*.*(..)
    //   任意访问修饰符    任意类 任意方法 任意参数
    @Before(value = "execution(* com.jason.lee.aop.annotation.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("前置通知——Method: " + name + ", Args: " + Arrays.toString(args));
    }


    /**
     * 后置通知相当于作用在finally语句块 即无论是否异常均执行后置逻辑
     * @param joinPoint
     */
    @After(value = "pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("后置通知——Method: " + name + ", Args: " + Arrays.toString(args));
    }


    /**
     * 返回通知  【方法执行后】
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "execution(* com.jason.lee.aop.annotation.*.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("返回通知——Method: " + name + ", Result: " + result);
    }


    @AfterThrowing(value = "execution(* com.jason.lee.aop.annotation.*.*(..))",throwing = "exception")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception exception) {
        String name = joinPoint.getSignature().getName();
        System.out.println("异常通知——Method: " + name + ", Exception: " + exception);
    }


    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = "execution(* com.jason.lee.aop.annotation.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        Object result;
        try {
            // 前置通知
            System.out.println("前置通知");
            result = proceedingJoinPoint.proceed(); // 执行方法
            // 返回通知
            System.out.println("返回通知");
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 异常通知
            System.out.println("异常通知");
        } finally {
            // 后置通知
            System.out.println("后置通知");
        }
        return -1;
    }
}
