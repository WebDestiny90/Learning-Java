package com.rabbit.fanout.topic.rabbtifanout.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
  String fullName;
  String surName;
  Integer age;
}
