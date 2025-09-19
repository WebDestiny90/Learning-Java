package com.carstore.carstore.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "marks")
public class MarksEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
  @Builder.Default
  Integer carCount= 0 ;
  @OneToMany(mappedBy = "marks")
 //@OneToMany
 // @JoinColumn(name = "marks")
  List<ModelEntity> modelEntities;
}