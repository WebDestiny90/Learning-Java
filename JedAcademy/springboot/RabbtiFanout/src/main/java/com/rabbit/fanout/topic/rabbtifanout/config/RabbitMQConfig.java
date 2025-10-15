package com.rabbit.fanout.topic.rabbtifanout.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
  public static final String EXCHANGE_NAME = "topic-exchange";

  public static final String USER_QUEUE = "user-queue";
  public static final String LOG_QUEUE = "log-queue";

  @Bean
  public TopicExchange topicExchange() {
    return new TopicExchange(EXCHANGE_NAME);
  }

  @Bean
  public Queue userQueue() {
    return new Queue(USER_QUEUE,true);
  }

  @Bean
  public Queue logQueue() {
    return new Queue(LOG_QUEUE,true);
  }

  @Bean
  public Binding userBinding(Queue userQueue, TopicExchange topicExchange) {
    return BindingBuilder.bind(userQueue).to(topicExchange).with("user.*");
  }

  @Bean
  public Binding logBinding(Queue logQueue, TopicExchange topicExchange) {
    return BindingBuilder.bind(logQueue).to(topicExchange).with("log.#");
  }


  @Bean
  public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate rabbitTemplate(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory) {
    RabbitTemplate template = new RabbitTemplate(connectionFactory);
    template.setMessageConverter(jackson2JsonMessageConverter());
    return template;
  }
}
