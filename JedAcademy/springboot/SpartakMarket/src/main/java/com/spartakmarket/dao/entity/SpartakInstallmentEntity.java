package com.spartakmarket.dao.entity;

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
@Table(name = "installment_detail")
public class SpartakInstallmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String productName;
    Double productPrice;

    @CreationTimestamp
    LocalDateTime takenAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    SpartakEntity user;
}
