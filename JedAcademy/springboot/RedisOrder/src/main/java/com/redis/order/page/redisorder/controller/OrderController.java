package com.redis.order.page.redisorder.controller;

import com.redis.order.page.redisorder.dto.OrderRequestDto;
import com.redis.order.page.redisorder.dto.OrderResponseDto;
import com.redis.order.page.redisorder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;

  @PostMapping("/add")
  public Long addOrder(@RequestBody OrderRequestDto requestDto) {
    return orderService.addOrder(requestDto);
  }

  @GetMapping("{id}")
  public OrderResponseDto getOrder(@PathVariable Long id) {
    return orderService.getOrderById(id);
  }

}
