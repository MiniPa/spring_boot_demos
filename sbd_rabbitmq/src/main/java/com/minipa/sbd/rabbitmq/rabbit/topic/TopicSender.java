package com.minipa.sbd.rabbitmq.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TopicSender:
 * 
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-01 shared by all free coders 
 **/
@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String msg = "message all";
		System.out.println("Sended : " + msg);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.1", msg);
	}

	public void send1() {
		String msg = "message 1";
		System.out.println("Sended : " + msg);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", msg);
	}

	public void send2() {
		String context = "messages 2";
		System.out.println("Sended : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
	}

}