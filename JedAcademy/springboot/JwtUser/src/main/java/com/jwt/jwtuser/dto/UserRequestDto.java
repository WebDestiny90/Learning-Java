package com.jwt.jwtuser.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {
  String firstName;
  String surName;
  Integer userPassword;
}
