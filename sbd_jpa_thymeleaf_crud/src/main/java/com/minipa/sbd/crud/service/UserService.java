package com.minipa.sbd.crud.service;


import com.minipa.sbd.crud.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);


}
