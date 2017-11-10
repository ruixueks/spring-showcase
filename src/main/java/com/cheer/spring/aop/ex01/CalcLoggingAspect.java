/*
 * 文件名：CalcLoggingAspect.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2017年11月10日
 */

package com.cheer.spring.aop.ex01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CalcLoggingAspect
{
    private static final Logger LOGGER = LogManager.getLogger(CalcLoggingAspect.class);
    
    //标识这个方法是个前置通知,切点表达式表示执行 ArithmeticCalculator接口的 add()方法 
    // * 代表匹配任意修饰符及任意返回值,
    //参数列表中的 .. 匹配任意数量的参数
//    @Before("execution(* com.cheer.spring.aop.impl.ArithmeticCalculator.add(..))")
//    public void logBefore()
//    {
//        LOGGER.info("The method add() begins");
//    }
//    
//    @After("execution(* com.cheer.spring.aop.impl.ArithmeticCalculator.add(..))")
//    public void logAfter()
//    {
//        LOGGER.info("The method add() ends");
//    }
    
    @Pointcut("execution(* com.cheer.spring.aop.impl.ArithmeticCalculator.add(..))")
    private void loggingOperation()
    {}
    
    @Before("loggingOperation()")
    public void logBefore()
    {
        LOGGER.info("The method add() begins");
    }
    
    @After("loggingOperation()")
    public void logAfter()
    {
        LOGGER.info("The method add() ends");
    }
}
