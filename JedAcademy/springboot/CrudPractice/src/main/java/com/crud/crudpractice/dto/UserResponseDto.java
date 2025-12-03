package com.crud.crudpractice.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
  Long id;
  String firstName;
  String lastName;
  Integer age;
}
