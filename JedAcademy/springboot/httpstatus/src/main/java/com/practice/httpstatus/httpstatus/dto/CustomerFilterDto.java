package com.practice.httpstatus.httpstatus.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerFilterDto {
  String fullName;
  String surName;
  String email;
  String password;
  Integer page = 0;
  Integer size = 5;
}
