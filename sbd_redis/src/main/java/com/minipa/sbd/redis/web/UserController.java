package com.minipa.sbd.redis.web;

import com.minipa.sbd.redis.domain.User;
import com.minipa.sbd.redis.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/getUser")
  @Cacheable(value = "user-key")
  public User getUser() {
    User user = userRepository.findByUserName("aa");
    System.out.println("第一次访问,从数据库取得数据,会打印此日志。后面的访问，若走缓存路线，" +
        "则不会打印此日志，并且页面能够接收到查询的信息。");
    return user;
  }

  @RequestMapping("/getUsers")
  @Cacheable(value = "key-Users")
  public List<User> getUsers() {
    List<User> users = userRepository.findAll();
    System.out.println("第一次访问,从数据库取得数据,会打印此日志。后面的访问，若走缓存路线，" +
        "则不会打印此日志，并且页面能够接收到查询的信息。");
    return users;
  }
}