package com.redis.user.userredis.dto;

import com.redis.user.userredis.util.GenderEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
  String firstName;
  String lastName;
  Integer age;
  GenderEnum gender;
}
