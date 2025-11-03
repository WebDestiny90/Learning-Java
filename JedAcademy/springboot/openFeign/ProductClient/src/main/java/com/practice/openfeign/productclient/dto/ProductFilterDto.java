package com.practice.openfeign.productclient.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductFilterDto {
  String title;
  Double price;
  Integer stock;
  Integer page = 0;
  Integer size = 6;
}
