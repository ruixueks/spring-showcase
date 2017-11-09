/*
 * 文件名：PetServiceImpl.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月8日
 */

package com.cheer.spring.ioc.anntation.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.spring.ioc.anntation.dao.PetDao;
import com.cheer.spring.ioc.anntation.service.PetService;


@Service
public class PetServiceImpl implements PetService
{
    @Autowired
    private PetDao petDao;

    @Override
    public int find(String username, String password)
    {
        return this.petDao.find(username, password);
    }

}
