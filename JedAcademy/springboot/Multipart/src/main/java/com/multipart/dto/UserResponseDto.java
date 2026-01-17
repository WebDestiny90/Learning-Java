package com.multipart.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
  String firstName;
  String surName;

  // Frontend-in birbaşa istifadə edəcəyi şəkil URL-i  // YENİ
  String imageUrl; // YENİ
}
