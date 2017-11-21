package com.minipa.sbd.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController:
 * author: Chengjs, version:1.0.0, 2017-11-21
 * @RestController 意味controller里面的方法都以json格式输出，不用再写什么jackjson配置
 */
@RestController
public class HelloController {

  @RequestMapping("/hello") // http://localhost:8080/hello
  public String hello() {
    return "Hello World";
  }


}
