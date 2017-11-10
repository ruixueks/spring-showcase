/*
 * 文件名：CalcValidationHandler.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2017年11月9日
 */

package com.cheer.spring.aop.impl;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

public class CalcValidationHandler implements InvocationHandler
{
    private Object target;
    
    public CalcValidationHandler()
    {}
    
    public CalcValidationHandler(Object target)
    {
        this.target = target;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        for(Object arg : args)
        {
            validate((Double)arg);
        }
        
        Object result = method.invoke(target, args);
        
        return result;
    }
    
    public static Object createProxy(Object target)
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new CalcValidationHandler(target));
    }
    
    private void validate(double a)
    {
        if(a < 0)
        {
            throw new IllegalArgumentException("Positive numbers only");
        }
    }
}
