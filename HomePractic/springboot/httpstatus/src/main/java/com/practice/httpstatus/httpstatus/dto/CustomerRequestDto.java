package com.practice.httpstatus.httpstatus.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequestDto {
  String fullName;
  String surName;
  String email;
  String password;
}
