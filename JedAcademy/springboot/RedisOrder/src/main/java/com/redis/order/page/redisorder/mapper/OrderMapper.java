package com.redis.order.page.redisorder.mapper;

import com.redis.order.page.redisorder.dao.entity.OrderEntity;
import com.redis.order.page.redisorder.dto.OrderRequestDto;
import com.redis.order.page.redisorder.dto.OrderResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
  OrderEntity requestDtoToEntity(OrderRequestDto requestDto);
  OrderResponseDto responseToDto(OrderEntity responseDto);
}
