package com.spring.manytoone.onetomany.dto;

import com.spring.manytoone.onetomany.dao.entity.CustomerEntity;
import com.spring.manytoone.onetomany.dao.entity.OrderEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponseDto {
  Long id;
  String name;
  List<OrderEntity> userOrder;
}


