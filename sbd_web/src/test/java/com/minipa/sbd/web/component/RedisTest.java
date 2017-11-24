package com.minipa.sbd.web.component;

import com.minipa.sbd.web.domain.User;
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

/**
 * RedisTest: 如下用手动方式来实现缓存 @Cacheable(value="user-key") 注解使用
 *
 * @version 0.0.1  @date: 2017-11-24
 * @author: <a href="mailto:chengjs_minipa@outlook.com">chengjs_minipa</a>,
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private RedisTemplate redisTemplate;

  /**
   * 缓存String
   *
   * @throws Exception
   */
  @Test
  public void test() throws Exception {
    ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
    valueOperations.set("eric", "man");
    valueOperations.get("eric");

    /*尚不知opsForValue是否是每次执行获取一次链接,所以上下执行方式是否有差异还不清楚*/

    stringRedisTemplate.opsForValue().set("xiaoming", "12");
    Assert.assertEquals("12", stringRedisTemplate.opsForValue().get("xiaoming"));
  }

  /**
   * 缓存对象
   *
   * @throws Exception
   */
  @Test
  public void testObj() throws Exception {
    User user = new User("eric@outlook.com", "BigEric", "123", "eric", "987");
    ValueOperations<String, User> operations = redisTemplate.opsForValue();
    operations.set("user.eric", user);
    operations.set("user.eric.f", user, 1, TimeUnit.SECONDS);
    Thread.sleep(1000);

    //redisTemplate.delete("user.eric.f");
    boolean exists = redisTemplate.hasKey("user.eric.ff");
    if (exists) {
      System.out.println("exists is true");
    } else {
      System.out.println("exists is false");
    }
    Assert.assertEquals("eric", operations.get("user.eric.f").getUserName());
  }


}