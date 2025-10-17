package com.manytoone.manytoone.dao.entity;

import com.manytoone.manytoone.util.ColorEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
  Double price;
  String color;
  @ManyToOne
  @JoinColumn(name = "category_id")
  CategoryEntity category;
}
