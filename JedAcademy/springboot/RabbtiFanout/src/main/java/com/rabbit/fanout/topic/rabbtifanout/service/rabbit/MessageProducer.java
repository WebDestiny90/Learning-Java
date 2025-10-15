package com.rabbit.fanout.topic.rabbtifanout.service.rabbit;

import com.rabbit.fanout.topic.rabbtifanout.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MessageProducer {
  private final RabbitTemplate rabbitTemplate;

  public void sendUserNotification(Object message){
    rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,"user.create",message);
  }
  public void sendLogNotification(Object message){
    rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,"log.create.info",message);
  }
}
