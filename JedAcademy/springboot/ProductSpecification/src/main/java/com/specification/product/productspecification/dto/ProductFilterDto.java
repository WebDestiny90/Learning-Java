package com.specification.product.productspecification.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductFilterDto {
  String title;
  String brand;
  String category;
  BigDecimal priceMin;
  BigDecimal priceMax;
  Integer stockMin;
  Integer stockMax;
  Double ratingMin;
  Double ratingMax;
  LocalDateTime createdStart;
  LocalDateTime createdEnd;
  Boolean active;
  Integer page = 0;
  Integer size = 10; // default 10
}
