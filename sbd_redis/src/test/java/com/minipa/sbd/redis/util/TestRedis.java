package com.minipa.sbd.redis.util;

import com.minipa.sbd.redis.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private RedisTemplate redisTemplate;

  @Test
  public void test() throws Exception {
    stringRedisTemplate.opsForValue().set("mini1", "111");
    Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("mini1"));
  }

  @Test
  public void testObj() throws Exception {
    User user = new User("mini1@126.com", "mini1", "mini1123456", "mini1", "123");
    ValueOperations<String, User> operations = redisTemplate.opsForValue();
    operations.set("com.minipa", user);
    operations.set("com.minipa.f", user, 1, TimeUnit.SECONDS);
    Thread.sleep(1000);
    //redisTemplate.delete("com.minipa.f");
    boolean exists = redisTemplate.hasKey("com.minipa.f");
    if (exists) {
      System.out.println("exists is true");
    } else {
      System.out.println("exists is false");
    }
    // Assert.assertEquals("mini1", operations.get("com.neo.f").getUserName());
  }

}