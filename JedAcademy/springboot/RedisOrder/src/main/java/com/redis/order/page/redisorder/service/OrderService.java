package com.redis.order.page.redisorder.service;

import com.redis.order.page.redisorder.dao.repository.OrderRepository;
import com.redis.order.page.redisorder.dto.OrderRequestDto;
import com.redis.order.page.redisorder.dto.OrderResponseDto;
import com.redis.order.page.redisorder.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
  public final static String ORDER_PREFIX = "ORDER";
  public final OrderRepository orderRepository;
  public final OrderMapper orderMapper;
  public final RedisService redisService;

  public Long addOrder(OrderRequestDto requestDto) {
    var order = orderRepository.save(orderMapper.requestDtoToEntity(requestDto));
    return order.getId();
  }

  public OrderResponseDto getOrderById(Long id) {
    var redisData = redisService.getValue(ORDER_PREFIX);
    if (redisData != null) {
      log.info("Data loaded from Redis");
      return (OrderResponseDto) redisData;
    }

    log.info("Data loaded from Repository");
    var data = orderRepository.findById(id).orElseThrow(()-> new RuntimeException( "Order not found with id:" + id));
    OrderResponseDto responseDto = orderMapper.responseToDto(data);
    redisService.setValueS(ORDER_PREFIX, responseDto, 600);
    return responseDto;
  }
}
