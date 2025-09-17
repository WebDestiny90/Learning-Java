package com.spring.mapstruct.mapstruct.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto {
  String customerName;
  String title;
  String description;
  List<OrderDto> news;
}
