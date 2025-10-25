package com.otpcode.otpcode.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OtpDateFormatter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static String format(LocalDateTime time) {
        if (time == null) return null;
        return time.format(FORMATTER);
    }
}