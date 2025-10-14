package com.redis.rabbit.page.rabbituser.service.rabbit;

import com.redis.rabbit.page.rabbituser.dao.repository.UserRepository;
import com.redis.rabbit.page.rabbituser.dto.UserRequestDto;
import com.redis.rabbit.page.rabbituser.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RabbitMQReceiver {
  private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQReceiver.class);
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @RabbitListener(queues = "User")
  public void receiveMessage(UserRequestDto requestDto) {
    try {
      LOGGER.info("Received message {}", requestDto);
      var userEntity = userMapper.requestDtoToEntity(requestDto);
      var savedUser = userRepository.save(userEntity);
      LOGGER.info("Car saved successfully with ID: {}", savedUser.getId());
    } catch (Exception e) {
      LOGGER.error("Failed to process message: {}", requestDto, e);
    }
  }
}
