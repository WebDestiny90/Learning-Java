package com.spartakmarket.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "installment")
public class SpartakEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String firstName;
  String fatherName;
  Integer phoneNumber;
  Double totalDebt;
  @CreationTimestamp
  LocalDateTime installmentAt;
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  List<SpartakInstallmentEntity> installments;
}
