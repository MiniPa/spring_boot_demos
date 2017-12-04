package com.minipa.sbd.rabbitmq.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FanoutSender:
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-01 shared by all free coders
 **/
@Component
public class FanoutSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String msg = "fanout msg ";
		System.out.println("Sended : " + msg);
		this.rabbitTemplate.convertAndSend("fanoutExchange","", msg);
	}

}