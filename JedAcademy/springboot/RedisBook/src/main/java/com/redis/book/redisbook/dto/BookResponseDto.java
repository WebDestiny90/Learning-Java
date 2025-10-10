package com.redis.book.redisbook.dto;

import com.redis.book.redisbook.util.GenreEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponseDto {
  String title;
  String author;
  GenreEnum genre;
}
