package com.post.postrequest.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "human")
@NoArgsConstructor
public class HumanEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String first_name;
  private String last_name;
  private Integer age;
  @CreationTimestamp
  private LocalDateTime created_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;

  public HumanEntity(String first_name, String last_name, Integer age) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.age = age;
  }
}
