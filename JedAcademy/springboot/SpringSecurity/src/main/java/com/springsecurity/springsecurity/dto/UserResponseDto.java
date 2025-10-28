package com.springsecurity.springsecurity.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
  String firstName;
  String surName;
  String email;
  String password;
}
