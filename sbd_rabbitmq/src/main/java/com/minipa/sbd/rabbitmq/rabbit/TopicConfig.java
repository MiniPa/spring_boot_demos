package com.minipa.sbd.rabbitmq.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TopicRabbitConfig: 按规则转发消息（最灵活） 根据通配符
 *
 * 队列和交换机的绑定会定义一种路由模式,通配符就要在这种路由模式和路由键之间匹配后交换机才能转发消息1.路由键必须是一串字符，用句号（.） 隔开，
 * 比如说 company.us,或者 company.cn.shanghai 等2.路由模式必须包含一个 星号（*），用于匹配路由键指定位置的一个单词
 *    e.g.shanghai..b.*: 第一单词shanghai,第四单词b,
 *        shanghai.a.# 以shanghai.a.开头的都匹配
 *        #代表一个或多个单词, *代表一个单词 *
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-01 shared by all free coders 
 **/
@Configuration
public class TopicConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicConfig.messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
