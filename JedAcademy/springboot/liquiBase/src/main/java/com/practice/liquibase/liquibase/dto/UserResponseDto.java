package com.practice.liquibase.liquibase.dto;

import com.practice.liquibase.liquibase.util.GenderEnum;
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
