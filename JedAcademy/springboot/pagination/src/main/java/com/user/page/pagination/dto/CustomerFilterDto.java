package com.user.page.pagination.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerFilterDto {
  String name;
  String surName;
  Integer age;
  Integer page = 0;
  Integer size = 6;
}
