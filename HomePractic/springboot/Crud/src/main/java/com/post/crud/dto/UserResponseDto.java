package com.post.crud.dto;

import com.post.crud.util.Gender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
  String fullName;
  String surName;
  Integer age;
  Gender gender;
}
