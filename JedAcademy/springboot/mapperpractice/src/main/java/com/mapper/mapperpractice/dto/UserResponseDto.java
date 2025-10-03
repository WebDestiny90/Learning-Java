package com.mapper.mapperpractice.dto;

import com.mapper.mapperpractice.util.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
  String fullName;
  String surName;
  Integer age;
  Gender gender;
  String  email;
  @CreationTimestamp
  LocalDateTime registeredAt;
}
