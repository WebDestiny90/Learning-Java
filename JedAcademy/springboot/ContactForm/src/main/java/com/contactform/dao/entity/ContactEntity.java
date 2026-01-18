package com.contactform.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "contactform")
public class ContactEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Column(nullable = false)
  private String fullName; // adı

  @Column(nullable = false)
  private String email; // email

  @Column(nullable = false)
  private String subject; // mövzu

  @Column(columnDefinition = "TEXT") // Uzun mətnlər üçün
  private String message; // mesaj

  @CreationTimestamp
  private LocalDateTime createdAt; // yaranma tarixi
}
