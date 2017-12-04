package com.minipa.sbd.mongodb.dao;

import com.minipa.sbd.mongodb.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserDaoTest:
 * 
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-04 shared by all free coders 
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private IUserDao userDao;

    @Test
    public void testSaveUser() throws Exception {
        User user=new User();
        user.setId(123L);
        user.setUserName("eric");
        user.setPassWord("123456");
        userDao.saveUser(user);
    }

    @Test
    public void findUserByUserName(){
       User user= userDao.findUserByUserName("eric");
       System.out.println("user is "+user);
    }

    @Test
    public void updateUser(){
        User user=new User();
        user.setId(124L);
        user.setUserName("marry");
        user.setPassWord("123456");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById(){
        userDao.deleteUserById(123L);
    }

}
