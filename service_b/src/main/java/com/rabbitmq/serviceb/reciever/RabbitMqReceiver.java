package com.rabbitmq.serviceb.reciever;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

import com.rabbitmq.serviceb.model.User;


@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {
   
	private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);
  
	@Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }
   
	@RabbitListener(queues = "${spring.rabbitmq.queue_a}")
    public void receivedMessage(User user) {
        logger.info("User Details Received is.. " + user);
    }
}