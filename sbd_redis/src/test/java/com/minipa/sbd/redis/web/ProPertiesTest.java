package com.minipa.sbd.redis.web;

import com.minipa.sbd.redis.util.MinipaProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProPertiesTest {

  @Autowired
  private MinipaProperties minipaProperties;

  @Test
  public void getHello() throws Exception {
    System.out.println(minipaProperties.getTitle());
    Assert.assertEquals(minipaProperties.getTitle(), "Minipa");
    Assert.assertEquals(minipaProperties.getDescription(), "一名奇葩的coder，致力于微服务和大数据工作。");
  }

  @Test
  public void testMap() throws Exception {
    Map<String, Long> orderMinTime = new HashMap<String, Long>();
    long xx = orderMinTime.get("123");
  }

}