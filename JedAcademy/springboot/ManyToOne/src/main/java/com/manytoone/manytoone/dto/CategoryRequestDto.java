package com.manytoone.manytoone.dto;

import com.manytoone.manytoone.dao.entity.ProductEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryRequestDto {
  String title;
  String description;
  List<ProductEntity> products;
}
