package com.minipa.sbd.redis.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		userRepository.save(new User("mini11", "mini1@outlook.com", "mini1", "mini1123456",formattedDate));
		userRepository.save(new User("mini22", "mini2@outlook.com", "mini2", "mini2123456",formattedDate));
		userRepository.save(new User("mini33", "mini3@outlook.com", "mini3", "mini3123456",formattedDate));

		Assert.assertEquals(9, userRepository.findAll().size());
		Assert.assertEquals("mini2", userRepository.findByUserNameOrEmail("mini2", "mini3@outlook.com").getNickName());
		userRepository.delete(userRepository.findByUserName("mini11"));
	}

}