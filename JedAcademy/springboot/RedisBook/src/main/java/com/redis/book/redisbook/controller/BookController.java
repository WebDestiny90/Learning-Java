package com.redis.book.redisbook.controller;

import com.redis.book.redisbook.dto.BookRequestDto;
import com.redis.book.redisbook.dto.BookResponseDto;
import com.redis.book.redisbook.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @PostMapping("/add")
  public void addBook(@Valid @RequestBody BookRequestDto requestDto) {
    bookService.addBook(requestDto);
  }

  @GetMapping("{id}")
  public BookResponseDto getBook(@PathVariable Long id) {
   return bookService.getBook(id);
  }
}
