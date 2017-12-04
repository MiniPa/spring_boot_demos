package com.minipa.sbd.rabbitmq.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DirectConfig: 先匹配, 再投送. 绑定时设定的 routing_key 和消息的routing_key 匹配时,投送.
 *  default 默认的MQ模式
 * 
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-01 shared by all free coders 
 **/
@Configuration
public class DirectConfig {

    @Bean
    public Queue directQueue() {
        return new Queue("direct");
    }

    @Bean
    public Queue miniQueue() {
        return new Queue("mini");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }


}
