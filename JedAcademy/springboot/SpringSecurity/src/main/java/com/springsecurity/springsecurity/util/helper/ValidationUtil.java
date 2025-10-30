package com.springsecurity.springsecurity.util.helper;

import com.springsecurity.springsecurity.dto.EmailValidator;
import com.springsecurity.springsecurity.dto.PasswordValidator;
import com.springsecurity.springsecurity.dto.UserRequestDto;
import com.springsecurity.springsecurity.exception.InvalidEmailProvideException;
import com.springsecurity.springsecurity.exception.InvalidPasswordException;

public class ValidationUtil {

    public static void validateUser(UserRequestDto dto) {
        if (!EmailValidator.isValidEmail(dto.getEmail())) {
            throw new InvalidEmailProvideException("Please provide a valid email address");
        }

        if (!PasswordValidator.isValidPassword(dto.getPassword())) {
            throw new InvalidPasswordException("Please provide a valid password");
        }
    }
}
