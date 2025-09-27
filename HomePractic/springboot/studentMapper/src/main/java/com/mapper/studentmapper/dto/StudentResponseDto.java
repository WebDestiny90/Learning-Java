package com.mapper.studentmapper.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponseDto {
  String fullName;
  String surName;
  String age;
  LocalDateTime registeredAt;
}
