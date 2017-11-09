/*
 * 文件名：Container.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月8日
 */

package com.cheer.spring.ioc.ex01;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Container
{
    private static final Logger LOGGER = LogManager.getLogger(Container.class);

    // 存储类名与其对象
    private Map<String, Object> objs = new HashMap<>();

    @SuppressWarnings("rawtypes")
    public void init()
    {
        
        try
        {
            for (Entry entry : loadFile("config/beans.config.properties").entrySet())
            {
                // 获取Class对象
                Class clazz = Class.forName(entry.getValue().toString());

                // 通过反射的方式创建对象
                Object obj = clazz.newInstance();

                // 讲类名与其对象维护起来，放入map
                this.objs.put(entry.getKey().toString(), obj);
            }
            
            for (Entry entry : loadFile("config/dependency.config.properties").entrySet())
            {
                if (this.objs.containsKey(entry.getKey()))
                {
                    // 从类名--对象Map中获取对象
                    Object obj = this.objs.get(entry.getKey().toString());

                    // 获取Class对象
                    Class clazz = obj.getClass();

                    // 获取方法对象
                    @SuppressWarnings("unchecked")
                    Method method = clazz.getDeclaredMethod("setReportGenerator",
                        ReportGenerator.class);
                    
                    // 调用方法
                    method.invoke(obj, this.objs.get(entry.getValue()));
                }

            }

        }
        catch (ClassNotFoundException e)
        {
            LOGGER.catching(e);
        }
        catch (InstantiationException e)
        {
            LOGGER.catching(e);
        }
        catch (IllegalAccessException e)
        {
            LOGGER.catching(e);
        }
        catch (IllegalArgumentException e)
        {
            LOGGER.catching(e);
        }
        catch (InvocationTargetException e)
        {
            LOGGER.catching(e);
        }
        catch (NoSuchMethodException e)
        {
            LOGGER.catching(e);
        }
        catch (SecurityException e)
        {
            LOGGER.catching(e);
        }
    }

    public static Properties loadFile(String name)
    {
        InputStream in = Container.class.getResourceAsStream("/" + name);

        Properties props = new Properties();
        try
        {
            props.load(in);
        }
        catch (IOException e)
        {
            LOGGER.error("{}配置文件不存在", name);
        }
        finally
        {
            if (in != null)
            {
                try
                {
                    in.close();
                }
                catch (IOException e)
                {
                    LOGGER.catching(e);
                }
            }
        }

        return props;
    }

    public Object getComponent(String name)
    {
        if (this.objs.size() == 0)
        {
            this.init();
        }

        return this.objs.get(name);

    }
}
