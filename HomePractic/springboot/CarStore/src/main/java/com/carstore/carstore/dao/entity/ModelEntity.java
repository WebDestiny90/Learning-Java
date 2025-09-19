package com.carstore.carstore.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "model")
public class ModelEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String modelName;
  Double price;

 @ManyToOne
  @JoinColumn(name = "marka_id")
  MarksEntity marks;
}
