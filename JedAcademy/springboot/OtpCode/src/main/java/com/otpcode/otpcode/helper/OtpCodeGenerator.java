package com.otpcode.otpcode.helper;

import org.springframework.stereotype.Component;
import java.security.SecureRandom;

@Component
public class OtpCodeGenerator {

    private final SecureRandom random = new SecureRandom();

    public String generate() {
        return String.format("%04d", random.nextInt(10000));
    }
}