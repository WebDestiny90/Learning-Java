package com.otpcode.otpcode.dto;

import com.otpcode.otpcode.util.OtpStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SendOtpResponse {
  OtpStatus status;
  String blockedUntil;
  String expiresAt;
}