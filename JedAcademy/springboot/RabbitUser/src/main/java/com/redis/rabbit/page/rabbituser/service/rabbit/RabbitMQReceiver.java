package com.redis.rabbit.page.rabbituser.service.rabbit;

import com.redis.rabbit.page.rabbituser.dao.repository.UserRepository;
import com.redis.rabbit.page.rabbituser.dto.UserRequestDto;
import com.redis.rabbit.page.rabbituser.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitMQReceiver {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @RabbitListener(queues = "User")
  public void receiveMessage(UserRequestDto requestDto) {
    try {
      log.info("Received message {}", requestDto);
      var userEntity = userMapper.requestDtoToEntity(requestDto);
      var savedUser = userRepository.save(userEntity);
      log.info("Car saved successfully with ID: {}", savedUser.getId());
    } catch (Exception e) {
      log.error("Failed to process message: {}", requestDto, e);
    }
  }
}
