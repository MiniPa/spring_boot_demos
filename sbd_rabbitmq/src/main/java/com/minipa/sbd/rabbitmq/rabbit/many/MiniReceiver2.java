package com.minipa.sbd.rabbitmq.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "mini")
public class MiniReceiver2 {

    @RabbitHandler
    public void process(String mini) {
        System.out.println("mini Receiver 2: " + mini);
    }

}
