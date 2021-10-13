package com.tik.mysystem.security.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(queues = "myKey")
    public void receive(String message) {
        System.out.println("收到的 message 是：" + message);
    }

}
