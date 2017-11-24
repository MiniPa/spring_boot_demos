package com.minipa.sbd.web.controller;

import com.minipa.sbd.web.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController: JSON接口开发
 * 免去: jackson包,@ResponseBody等
 *
 * author: Chengjs, version:1.0.0, 2017-11-21
 * @RestController 意味controller里面的方法都以json格式输出，不用再写什么jackjson配置
 */
@RestController
public class HelloController {

  @RequestMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  @RequestMapping("/getUser")
  public User getUser() {
    User user=new User();
    user.setUserName("习大大");
    user.setPassWord("123");
    return user;
  }

}
