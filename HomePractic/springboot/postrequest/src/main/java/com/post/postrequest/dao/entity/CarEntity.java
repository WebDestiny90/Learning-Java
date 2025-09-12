package com.post.postrequest.dao.entity;

import com.post.postrequest.Color;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cars")
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String model;
  private String mark;
  private String year;
  private String engine;
  private String price;
  @Enumerated(EnumType.STRING)
  private Color color;
  @CreationTimestamp
  private LocalDateTime release_at;
  @UpdateTimestamp
  private LocalDateTime updated_at;

  public CarEntity(String model, String mark, String year, String engine, String price, Color color) {
    this.model = model;
    this.mark = mark;
    this.year = year;
    this.engine = engine;
    this.price = price;
    this.color = color;
  }
}
