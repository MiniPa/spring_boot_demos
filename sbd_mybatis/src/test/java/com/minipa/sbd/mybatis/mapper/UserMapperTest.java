package com.minipa.sbd.mybatis.mapper;

import com.minipa.sbd.mybatis.entity.User;
import com.minipa.sbd.mybatis.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * UserMapperTest:
 * author: Chengjs, version:1.0.0, 2017-11-29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

  @Autowired
  private UserMapper UserMapper;

  @Test
  public void testInsert() throws Exception {
    UserMapper.insert(new User(100L,"eric", "ericpwd", UserSexEnum.MAN));
    UserMapper.insert(new User(101L,"monica", "monicapwd", UserSexEnum.WOMAN));
    UserMapper.insert(new User(102L,"jney", "jneypwd", UserSexEnum.WOMAN));

    Assert.assertEquals(3, UserMapper.getAll().size());
  }

  @Test
  public void testQuery() throws Exception {
    List<User> users = UserMapper.getAll();
    System.out.println(users.toString());
  }


  @Test
  public void testUpdate() throws Exception {
    User user = UserMapper.getOne(3l);
    System.out.println(user.toString());
    user.setNickName("xiaoming");
    UserMapper.update(user);
    Assert.assertTrue(("neo".equals(UserMapper.getOne(3l).getNickName())));
  }

}