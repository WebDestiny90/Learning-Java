package com.spec.specification.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GameResponseDto {
  String title;
  String genre;
  Double price;
  Integer releaseYear;
}
