package com.rabbitmq.serviceb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.serviceb.model.User;
import com.rabbitmq.serviceb.sender.RabbitMqSenderB;


@RestController
@RequestMapping(value = "/api/srvb/")
public class SenderBController {
	
	private RabbitMqSenderB rabbitMqSenderB;
	   
	@Autowired
    public SenderBController(RabbitMqSenderB rabbitMqSenderB) {
        this.rabbitMqSenderB = rabbitMqSenderB;
    }
   
	@Value("${app.message}")
    private String message;
    
	@PostMapping(value = "user")
    public String publishUserDetails(@RequestBody User user) {
		rabbitMqSenderB.send(user);
        return message;
    }

}
