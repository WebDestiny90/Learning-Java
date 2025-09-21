package com.spring.customer.order.controller;

import com.spring.customer.order.dto.CommentsRequestDto;
import com.spring.customer.order.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentsController {
  private final CommentsService commentsService;

  @PostMapping("/add")
  public void addComments(@RequestBody CommentsRequestDto commentsRequestDto){
    commentsService.addComment(commentsRequestDto);
  }
}
