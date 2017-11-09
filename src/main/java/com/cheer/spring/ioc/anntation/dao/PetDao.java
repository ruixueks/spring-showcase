/*
 * 文件名：PetDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Cheer
 * 修改时间：2017年11月8日
 */

package com.cheer.spring.ioc.anntation.dao;

public interface PetDao
{
    int find(String name, String password);
}
