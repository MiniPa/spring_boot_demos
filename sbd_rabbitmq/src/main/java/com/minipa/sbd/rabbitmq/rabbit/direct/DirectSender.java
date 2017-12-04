package com.minipa.sbd.rabbitmq.rabbit.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * DirectSender:
 * 
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-01 shared by all free coders 
 **/
@Component
public class DirectSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String msg = "direct " + new Date();
		System.out.println("Sendered : " + msg);
		this.rabbitTemplate.convertAndSend("direct", msg);
	}

}