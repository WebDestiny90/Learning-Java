package com.redis.user.userredis.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponseDto {
  String firstName;
  String lastName;
  Integer age;
}
