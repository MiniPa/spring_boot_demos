package com.minipa.sbd.rabbitmq.rabbitmq;

import com.minipa.sbd.rabbitmq.rabbit.direct.DirectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DirectTest:
 * 
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-01 shared by all free coders 
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectTest {

	@Autowired
	private DirectSender helloSender;

	@Test
	public void send() throws Exception {
		helloSender.send();
	}

}