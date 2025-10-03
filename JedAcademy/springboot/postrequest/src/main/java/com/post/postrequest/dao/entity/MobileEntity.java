package com.post.postrequest.dao.entity;

import com.post.postrequest.Color;
import com.post.postrequest.OsEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Mobile_Baku")
public class MobileEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String mark;
  private String model;
  private int year;
  @Enumerated(EnumType.STRING)
  private Color color;
  @Enumerated(EnumType.STRING)
  private OsEnum oS;
  private boolean esimSupport;
  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;


}
