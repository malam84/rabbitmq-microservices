package com.rabbitmq.serviceb.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rabbitmq.serviceb.model.User;


@Service
public class RabbitMqSenderB {
    
	private RabbitTemplate rabbitTemplate;
    
    @Autowired
    public RabbitMqSenderB(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    
    @Value("${spring.rabbitmq.routing-key}")
    private String routingkey;
    
    public void send(User user){
        rabbitTemplate.convertAndSend(exchange,routingkey, user);
    }
}