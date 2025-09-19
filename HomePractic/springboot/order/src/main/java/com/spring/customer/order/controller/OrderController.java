package com.spring.customer.order.controller;

import com.spring.customer.order.dto.OrderRequestDto;
import com.spring.customer.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;

  @PostMapping("/add")
  public void addOrder(@RequestBody OrderRequestDto orderRequestDto){
    orderService.addOrder(orderRequestDto);
  }
}
