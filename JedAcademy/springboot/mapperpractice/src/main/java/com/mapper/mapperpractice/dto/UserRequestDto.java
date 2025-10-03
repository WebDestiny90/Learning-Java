package com.mapper.mapperpractice.dto;

import com.mapper.mapperpractice.util.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {
  String fullName;
  String surName;
  Integer age;
  Gender gender;
  String  email;
  Integer userPersonalKey;
}
