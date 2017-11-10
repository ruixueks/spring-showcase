/*
 * 文件名：AOPTest.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2017年11月9日
 */

package com.cheer.springtest;

import org.junit.Test;

import com.cheer.spring.aop.impl.ArithmeticCalculator;
import com.cheer.spring.aop.impl.ArithmeticCalculatorImpl;
import com.cheer.spring.aop.impl.CalcLoggingHandler;
import com.cheer.spring.aop.impl.CalcValidationHandler;

public class AOPTest
{
    @Test
    public void test1()
    {
        ArithmeticCalculator arithmeticCalculatorImpl = new ArithmeticCalculatorImpl();
        
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator)CalcValidationHandler.createProxy(CalcLoggingHandler.createProxy(arithmeticCalculatorImpl));

        System.out.println(arithmeticCalculator.add(2.0, 13.1));
        System.out.println(arithmeticCalculator.sub(2.0, 13.1));
    }
    
}
