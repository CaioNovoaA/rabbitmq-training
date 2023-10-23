package com.send.email.rabbitmq;

import com.send.email.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserMessageListener {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleMessage(User user) {
        System.out.println("Received message: " + user);
    }
}