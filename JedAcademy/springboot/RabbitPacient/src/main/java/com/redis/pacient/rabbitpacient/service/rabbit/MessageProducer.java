package com.redis.pacient.rabbitpacient.service.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MessageProducer {
  private final RabbitTemplate rabbitTemplate;

  public void sendMessage(Object message){
    rabbitTemplate.convertAndSend("","patient",message);
  }
}
