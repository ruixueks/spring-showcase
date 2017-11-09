/*
 * 文件名：MasterDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2017年11月9日
 */

package com.cheer.spring.ioc.anntation.dao;

public interface MasterDao
{
    int find(String name, String password);
}
