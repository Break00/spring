package com.jason.lee.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

/**
 * @author huanli9
 * @description
 * @date 2020/11/16 7:46
 */
@Aspect  //切面类
public class LogAspects {

    //抽取公共的切入点表达式
    //1、引用内部定义的切入点
    //2、引用外部类定义切入点
    @Pointcut("execution(public int com.jason.lee.annotation.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    //目标方法之前切入；切入点表达式（指定在那个方法切入）
    @Before(value = "execution(* com.jason.lee.annotation.aop.MathCalculator.div(..))")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "运行之前...参数列表是：{" + Arrays.asList(args) + "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "结束...");
    }

    @AfterReturning(value = "com.jason.lee.annotation.aop.LogAspects.pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "正常返回...运行结果：{" + result + "}");
    }

    //JoinPoint必须出现在参数列表的首位！！！
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logError(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "异常...异常信息：{" + exception.getMessage() + "}");
    }
}
