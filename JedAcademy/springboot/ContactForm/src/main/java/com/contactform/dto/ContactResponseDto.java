package com.contactform.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactResponseDto {
    private Long id;
    private String fullName;
    private String status;
    private LocalDateTime sentAt;
}