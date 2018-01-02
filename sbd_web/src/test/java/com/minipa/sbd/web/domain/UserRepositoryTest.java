package com.minipa.sbd.web.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

import com.minipa.sbd.web.domain.UserRepository;
import com.minipa.sbd.web.domain.User;

import static org.junit.Assert.*;

/**
 * UserRepositoryTest:
 *
 * @version 0.0.1  @date: 2017-11-24
 * @author: <a href="mailto:chengjs_minipa@outlook.com">chengjs_minipa</a>,
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void test() throws Exception {
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
    String formattedDate = dateFormat.format(date);

    userRepository.save(new User("xiaoming", "11@126.com", "11", "11123456",formattedDate));
    userRepository.save(new User("xiaohong", "22@126.com", "22", "22123456",formattedDate));
    userRepository.save(new User("xiaolan", "33@126.com", "33", "33123456",formattedDate));

    Assert.assertEquals(3, userRepository.findAll().size());
    Assert.assertEquals("22", userRepository.findByUserNameOrEmail("22", "33@126.com").getNickName());
    userRepository.delete(userRepository.findByUserName("xiaoming"));
    userRepository.delete(userRepository.findByUserName("xiaohong"));
    userRepository.delete(userRepository.findByUserName("xiaolan"));
  }

}