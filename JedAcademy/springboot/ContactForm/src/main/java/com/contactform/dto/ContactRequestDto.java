package com.contactform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ContactRequestDto {

    @NotBlank(message = "Ad boş ola bilməz")
    @Size(min = 3, max = 50, message = "Ad 3-50 simvol aralığında olmalıdır")
    private String fullName;

    @NotBlank(message = "Email boş ola bilməz")
    private String email;

    @NotBlank(message = "Mövzu boş ola bilməz")
    private String subject;

    @NotBlank(message = "Mesaj boş ola bilməz")
    @Size(min = 10, message = "Mesaj ən azı 10 simvoldan ibarət olmalıdır")
    private String message;
}