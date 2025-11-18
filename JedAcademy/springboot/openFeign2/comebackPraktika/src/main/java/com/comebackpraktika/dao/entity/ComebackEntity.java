package com.comebackpraktika.dao.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "comeback")
public class ComebackEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String firstName;
  @Column(name = "sur_name")
  String surName;
  Double balance;
  Integer balanceId;
  @Builder.Default
  Boolean deleted = false;
}