package com.manytoone.manytoone.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDto {
  String name;
  Double price;
  String color;
}
