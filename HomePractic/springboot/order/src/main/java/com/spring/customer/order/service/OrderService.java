package com.spring.customer.order.service;

import com.spring.customer.order.dao.entity.OrderEntity;
import com.spring.customer.order.dao.repository.CustomerRepository;
import com.spring.customer.order.dao.repository.OrderRepository;
import com.spring.customer.order.dto.OrderRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final CustomerRepository customerRepository;
  private final OrderRepository orderRepository;

  public void addOrder(OrderRequestDto orderRequestDto) {
    var customer = customerRepository.findById(
            orderRequestDto.getCustomerId())
            .orElseThrow(
            ()-> new RuntimeException("Order not found"));

    var order = OrderEntity.builder()
            .orderName(orderRequestDto.getOrderName())
            .price(orderRequestDto.getPrice())
            .customers(customer)
            .build();

    orderRepository.save(order);
    customerRepository.save(customer);
  }
}
