package com.redis.pacient.rabbitpacient.dao.entity;

import com.redis.pacient.rabbitpacient.util.DiseaseEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "patient")
public class PatientEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String fullName;
  String surName;
  Integer age;
  @Enumerated(EnumType.STRING)
  DiseaseEnum disease;
}
