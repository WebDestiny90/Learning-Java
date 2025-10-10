package com.redis.book.redisbook.service;

import com.redis.book.redisbook.dao.repository.BookRepository;
import com.redis.book.redisbook.dto.BookRequestDto;
import com.redis.book.redisbook.dto.BookResponseDto;
import com.redis.book.redisbook.mapper.BookMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    var book = bookRepository.save(bookMapper.requestToEntity(requestDto));
    if (requestDto.getGenre() == null){
      throw new RuntimeException("Kul kishi bashiva");
    }
    BookResponseDto bookResponseDto = bookMapper.responseToDto(book);

    redisService.setValue(BOOK_PREFIX + book.getId(), bookResponseDto);
  }

  public BookResponseDto getBook(Long id) {
    var redisData = redisService.getValue(BOOK_PREFIX + id);
    if (redisData != null) {
      log.info("Data loaded from Redis for key: {} ", id);
      return (BookResponseDto) redisData;
    }
    log.info("Loading Car from Repository (Cache Miss) for ID: {}", id);
    var getBooks = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found by id:" + id));
    BookResponseDto bookResponseDto = bookMapper.responseToDto(getBooks);
    redisService.setValue(BOOK_PREFIX, bookResponseDto);
    return bookResponseDto;
  }
}
