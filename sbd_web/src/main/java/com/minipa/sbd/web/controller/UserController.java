package com.minipa.sbd.web.controller;

import com.minipa.sbd.web.domain.User;
import com.minipa.sbd.web.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController: Redis注解使用方式
 * 手动方式见@link com.minipa.sbd.controller.component.RedisTest
 *
 * @author: <a href="mailto:chengjs_minipa@outlook.com">chengjs</a>, version:1.0.0, 2017/11/24
 */
@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  /**
   * value 值为缓存到redis中的key
   *
   * @return
   */
  @RequestMapping("/getRedisUser")
  @Cacheable(value = "user-key")
  public User getUser() {
    User user = userRepository.findByUserName("eric");//此处查询会去redis缓存中查找
    System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
    return user;
  }

  @RequestMapping("/getRedisUsers")
  @Cacheable(value = "key-Users")
  public List<User> getUsers() {
    List<User> users = userRepository.findAll();//此处查询会去redis缓存中查找
    System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
    return users;
  }
}