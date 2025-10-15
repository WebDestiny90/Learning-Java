package com.rabbit.fanout.topic.rabbtifanout.service.rabbit;

import com.rabbit.fanout.topic.rabbtifanout.config.RabbitMQConfig;
import com.rabbit.fanout.topic.rabbtifanout.dao.repository.UserRepository;
import com.rabbit.fanout.topic.rabbtifanout.dto.UserRequestDto;
import com.rabbit.fanout.topic.rabbtifanout.mapper.UserMapper;
import com.rabbit.fanout.topic.rabbtifanout.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitMQReceiver {
  private final RedisService redisService;
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @RabbitListener(queues = RabbitMQConfig.USER_QUEUE)
  public void receiveUserMessage(UserRequestDto requestDto) {
    log.info("Received message from queue {}: {}", RabbitMQConfig.USER_QUEUE, requestDto);
    saveUser(requestDto);
    saveLogs(requestDto);
  }

  private void saveUser(UserRequestDto requestDto) {
    try {
      var userEntity = userMapper.requestDtoToEntity(requestDto);
      var savedUser = userRepository.save(userEntity);
      log.info("User saved successfully to database with ID: {}", savedUser.getId());
    } catch (Exception e) {
      log.error("Failed to save user to database: {}", requestDto, e);
    }
  }

  private void saveLogs(UserRequestDto requestDto) {
    try {
      String key = "user-log:" + System.currentTimeMillis();
      redisService.setValue(key, requestDto);
      log.info("Log saved successfully to Redis:");
    } catch (Exception e) {
      log.error("Failed to save log in Redis: {}", requestDto, e);
    }
  }
}
