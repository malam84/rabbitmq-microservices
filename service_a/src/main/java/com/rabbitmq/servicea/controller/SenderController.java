package com.rabbitmq.servicea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.servicea.model.User;
import com.rabbitmq.servicea.sender.RabbitMqSender;

@RestController
@RequestMapping(value = "/api/srva/")
public class SenderController {
	
	private RabbitMqSender rabbitMqSender;
   
	@Autowired
    public SenderController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }
   
	@Value("${app.message}")
    private String message;
    
	@PostMapping(value = "user")
    public String publishUserDetails(@RequestBody User user) {
        rabbitMqSender.send(user);
        return message;
    }

}
