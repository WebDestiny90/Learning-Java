package com.spring.cache.springcache.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GamerStudentRequestDto {
  String name;
  String surname;
  Integer age;
  String cityCode;
}
