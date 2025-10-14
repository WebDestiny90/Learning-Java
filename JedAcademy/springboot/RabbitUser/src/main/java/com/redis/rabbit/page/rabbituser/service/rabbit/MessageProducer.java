package com.redis.rabbit.page.rabbituser.service.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MessageProducer {
  private final RabbitTemplate rabbitTemplate;

  public void sendMessage(Object message){
    rabbitTemplate.convertAndSend("","User",message);
  }
}
