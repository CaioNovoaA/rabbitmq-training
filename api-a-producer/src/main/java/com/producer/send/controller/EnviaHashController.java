package com.producer.send.controller;

import com.producer.send.repository.EnviaHashRepository;
import com.producer.send.service.RabbitMQService;
import com.producer.send.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send")
public class EnviaHashController {
    @Autowired
    RabbitMQService rabbitMQService;
    @Autowired
    private EnviaHashRepository enviaHashRepository;

    @Autowired
    public EnviaHashController(EnviaHashRepository enviaHashRepository) {
        this.enviaHashRepository = enviaHashRepository;
    }

    @PostMapping
    public void sendUserMessage(@RequestParam Long userId) {
        rabbitMQService.sendMessage(userId);
    }

}
