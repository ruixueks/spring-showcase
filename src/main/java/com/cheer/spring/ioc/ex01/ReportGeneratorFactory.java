/*
 * 文件名：ReportGeneratorFactory.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月8日
 */

package com.cheer.spring.ioc.ex01;

/**
 * 
 * 报表生成器工厂类
 * 
 * @author Cheer
 * @version 2017年11月8日
 * @see ReportGeneratorFactory
 * @since
 */
public class ReportGeneratorFactory
{
    public ReportGenerator getReportGenerator(int type)
    {
        if (type == 1)
        {
            return new HtmlReportGenerator();
        }

        if (type == 0)
        {
            return new PdfReportGenerator();
        }

        return null;
    }
}
