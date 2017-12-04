package com.minipa.sbd.rabbitmq.rabbit.object;

import com.minipa.sbd.rabbitmq.mode.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ObjectSender:
 * 
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-01 shared by all free coders 
 **/
@Component
public class ObjectSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(User user) {
		System.out.println("Sended object: " + user.toString());
		this.rabbitTemplate.convertAndSend("object", user);
	}

}