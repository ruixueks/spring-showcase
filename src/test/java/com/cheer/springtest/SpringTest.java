package com.cheer.springtest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cheer.spring.helloworld.MessagePrinter;
import com.cheer.spring.helloworld.MessageService;

/*
 * 文件名：SpringTest.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2017年11月7日
 */

public class SpringTest
{
    @Test
    public void testOldStyle()
    {
        MessageService msgService = new MessageService();
        
        MessagePrinter msgPrinter = new MessagePrinter();
        
        msgPrinter.setMsgService(msgService);
        
        msgPrinter.printMessage();
    }
    
    @SuppressWarnings("resource")
    @Test
    public void testSpringStyle()
    {
        // Spring特性 IOC DI(Dependency Injection) 依赖注入
        // Spring的beans工厂帮助我们创建对象（通过反射的方式Class.forName("")）
        ApplicationContext apc = new ClassPathXmlApplicationContext("spring/spring.beans.xml");
        
        MessagePrinter msgPrinter = apc.getBean(MessagePrinter.class);
        
        msgPrinter.printMessage();
        
    }
}
