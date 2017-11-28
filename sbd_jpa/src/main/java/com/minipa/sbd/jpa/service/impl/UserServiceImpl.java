package com.minipa.sbd.jpa.service.impl;

import com.minipa.sbd.jpa.entity.User;
import com.minipa.sbd.jpa.repository.UserRepository;
import com.minipa.sbd.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl:
 * 
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
 * @version: 1.0.0, 2017-11-28 
 * 
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FCH LIMITED Shanghai Servyou Ltd 2017
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }
}


