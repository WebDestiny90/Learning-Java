package com.redis.book.redisbook.service;

import com.redis.book.redisbook.dao.entity.BookEntity;
import com.redis.book.redisbook.dao.repository.BookRepository;
import com.redis.book.redisbook.dto.BookRequestDto;
import com.redis.book.redisbook.dto.BookResponseDto;
import com.redis.book.redisbook.dto.PageResponse;
import com.redis.book.redisbook.helper.LogUtils;
import com.redis.book.redisbook.mapper.BookMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
  private static final String BOOK_PREFIX = "book";
  private final BookRepository bookRepository;
  private final BookMapper bookMapper;
  private final RedisService redisService;

  @Transactional
  public void addBook(BookRequestDto requestDto) {
    bookRepository.save(bookMapper.requestToEntity(requestDto));
  }

  public BookResponseDto getBook(Long id) {
    String key = BOOK_PREFIX + id;
    var redisData = redisService.getValue(key);
    if (redisData != null) {
      log.info("Data loaded from Redis for key: {} ", id);
      return (BookResponseDto) redisData;
    }
    log.info("Loading Data from Repository (Cache Miss) for ID: {}", id);
    var getBooks = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found by id:" + id));
    BookResponseDto bookResponseDto = bookMapper.responseToDto(getBooks);
    redisService.setValue(key, bookResponseDto);
    return bookResponseDto;
  }

  public PageResponse<BookResponseDto> getBooks(Integer page, Integer size) {
    long start = System.currentTimeMillis();

    String key = BOOK_PREFIX + ":PAGE:" + page + ":SIZE:" + size;

    var redisData = redisService.getValue(key);
    if (redisData != null) {
      LogUtils.logDuration("Data loaded from Redis for page " + page, start);
      return (PageResponse<BookResponseDto>) redisData;
    }

    Page<BookEntity> pageData = bookRepository.findAll(PageRequest.of(page, size));
    var dtoList = bookMapper.responseListToDto(pageData.getContent());

    LogUtils.logDuration("Cache miss for page " + page + ". Repository fetch completed", start);

    PageResponse<BookResponseDto> response = new PageResponse<>(
            dtoList,
            pageData.getNumber(),
            pageData.getSize(),
            pageData.getTotalElements(),
            pageData.getTotalPages()
    );

    redisService.setValueS(key, response, 600);

    return response;
  }

}
