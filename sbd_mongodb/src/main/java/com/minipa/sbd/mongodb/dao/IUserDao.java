package com.minipa.sbd.mongodb.dao;

import com.minipa.sbd.mongodb.entity.User;

/**
 * IUserDao:
 * 
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-04 shared by all free coders 
 **/
public interface IUserDao {

    public void saveUser(User user);

    public User findUserByUserName(String userName);

    public int updateUser(User user);

    public void deleteUserById(Long id);

}
