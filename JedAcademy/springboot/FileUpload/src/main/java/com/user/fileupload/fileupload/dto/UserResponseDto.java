package com.user.fileupload.fileupload.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
  String firstName;
  String surName;
}
