package com.specification.product.productspecification.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {
  String title;
  String description;
  BigDecimal price;
  Integer stock;
  String brand;
  String category;
  LocalDateTime createdAt;
  Boolean active;
  Double rating;
}
