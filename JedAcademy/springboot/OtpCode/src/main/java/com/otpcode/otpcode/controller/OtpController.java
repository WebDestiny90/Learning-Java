package com.otpcode.otpcode.controller;

import com.otpcode.otpcode.dto.SendOtpResponse;
import com.otpcode.otpcode.service.OtpSendService;
import com.otpcode.otpcode.service.OtpVerifyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/otp")
@RequiredArgsConstructor
public class OtpController {

  private final OtpSendService otpSendService;
  private final OtpVerifyService otpVerifyService;

  @PostMapping("/send")
  public ResponseEntity<SendOtpResponse> sendOtp(@RequestParam String phoneNumber) {
    return ResponseEntity.ok(otpSendService.sendOtp(phoneNumber));
  }

  @PostMapping("/verify")
  public ResponseEntity<String> verifyOtp(@RequestParam String phoneNumber,
                                          @RequestParam String otp) {
    return otpVerifyService.verifyOtp(phoneNumber, otp);
  }
}
