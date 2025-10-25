package com.otpcode.otpcode.dao.entity;

import com.otpcode.otpcode.util.OtpStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "otp")
public class OtpAttemptEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String phoneNumber;
  Integer requestCount;
  @Enumerated(EnumType.STRING)
  OtpStatus status;

  LocalDateTime blockUntil;
}
