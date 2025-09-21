package com.spring.customer.order.service;

import com.spring.customer.order.dao.entity.CommentsEntity;
import com.spring.customer.order.dao.repository.CommentsRepository;
import com.spring.customer.order.dao.repository.CustomerRepository;
import com.spring.customer.order.dto.CommentsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentsService {
  private final CustomerRepository customerRepository;
  private final CommentsRepository commentsRepository;

  public void addComment(CommentsRequestDto commentsRequestDto) {
    var customer = customerRepository.findById(
                    commentsRequestDto.getCustomerId())
                    .orElseThrow(
                    ()-> new RuntimeException("Comments not found"));

    var comments = CommentsEntity.builder()
                   .comment(commentsRequestDto.getComment())
                   .customers(customer)
                   .build();

    commentsRepository.save(comments);
    customerRepository.save(customer);
  }
}
