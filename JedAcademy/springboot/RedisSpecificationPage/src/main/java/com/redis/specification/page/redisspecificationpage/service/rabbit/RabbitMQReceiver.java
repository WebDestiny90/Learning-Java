package com.redis.specification.page.redisspecificationpage.service.rabbit;

import com.redis.specification.page.redisspecificationpage.dao.repository.CarRepository;
import com.redis.specification.page.redisspecificationpage.dto.CarRequestDto;
import com.redis.specification.page.redisspecificationpage.mapper.CarMapper;
import com.redis.specification.page.redisspecificationpage.service.CarService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RabbitMQReceiver {
  private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQReceiver.class);
  private final CarRepository carRepository;
  private final CarMapper carMapper;

  @RabbitListener(queues = "Cars")
  public void receiveMessage(CarRequestDto requestDto) {
    try {
      LOGGER.info("Received message {}", requestDto);
      var carEntity = carMapper.requestDtoToEntity(requestDto);
      var savedCar = carRepository.save(carEntity);
      LOGGER.info("Car saved successfully with ID: {}", savedCar.getId());
    } catch (Exception e) {
      LOGGER.error("Failed to process message: {}", requestDto, e);
    }
  }
}
