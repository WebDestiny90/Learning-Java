package com.contactform.helper;

import com.contactform.dto.ContactRequestDto;
import com.contactform.dto.EmailValidator;
import com.contactform.exception.InvalidEmailProvideException;

public class ValidationUtil {

    public static void validateUser(ContactRequestDto dto) {
        if (!EmailValidator.isValidEmail(dto.getEmail())) {
            throw new InvalidEmailProvideException("Düzgün email formatı daxil edin");
        }
    }
}
