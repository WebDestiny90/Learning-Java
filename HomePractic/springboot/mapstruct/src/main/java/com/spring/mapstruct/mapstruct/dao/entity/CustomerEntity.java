package com.spring.mapstruct.mapstruct.dao.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "customer")
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String customerName;
}
