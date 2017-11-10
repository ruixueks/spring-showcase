/*
 * 文件名：ArithmeticCalculatorImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2017年11月9日
 */

package com.cheer.spring.aop.impl;

import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator
{
    @Override
    public double add(double i, double j)
    {       
        double result  = i + j;
        return result;
    }
    
    @Override
    public double sub(double i, double j)
    {        
        double result  = i - j;
        return result;
    }
}
