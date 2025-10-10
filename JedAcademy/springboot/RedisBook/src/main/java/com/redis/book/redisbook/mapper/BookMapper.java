package com.redis.book.redisbook.mapper;

import com.redis.book.redisbook.dao.entity.BookEntity;
import com.redis.book.redisbook.dto.BookRequestDto;
import com.redis.book.redisbook.dto.BookResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
  BookEntity requestToEntity (BookRequestDto requestDto);
  BookResponseDto responseToDto(BookEntity responseDto);
  List<BookResponseDto> responseListToDto(List<BookEntity> responseListDto);
}
