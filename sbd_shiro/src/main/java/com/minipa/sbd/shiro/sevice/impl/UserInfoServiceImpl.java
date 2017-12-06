package com.minipa.sbd.shiro.sevice.impl;

import com.minipa.sbd.shiro.dao.UserInfoDao;
import com.minipa.sbd.shiro.entity.UserInfo;
import com.minipa.sbd.shiro.sevice.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}