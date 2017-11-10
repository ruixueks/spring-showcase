/*
 * 文件名：SpringAopTest.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2017年11月10日
 */

package com.cheer.springtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cheer.spring.aop.impl.ArithmeticCalculator;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath*:spring/spring.*.xml")
public class SpringAopTest
{
    @Autowired
    ArithmeticCalculator calc;
    
    @Test
    public void aopTest()
    {
        calc.add(1.0, 12.0);
    }
}
