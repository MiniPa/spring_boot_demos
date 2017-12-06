package com.minipa.sbd.shiro.sevice;


import com.minipa.sbd.shiro.entity.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}