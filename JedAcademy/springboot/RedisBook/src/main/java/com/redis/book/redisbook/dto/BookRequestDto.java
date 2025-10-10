package com.redis.book.redisbook.dto;

import com.redis.book.redisbook.util.GenreEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class BookRequestDto {
  @NotBlank(message = "Title cannot be blank!")
  String title;
  @NotBlank(message = "Author cannot be blank!")
  String author;
//  @NotNull(message = "Genre must not be blank!")
  GenreEnum genre;
}
