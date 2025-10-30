package com.springsecurity.springsecurity.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

  public static boolean isValidPassword(String password) {
    String regExpn = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";

    Pattern pattern = Pattern.compile(regExpn);
    Matcher matcher = pattern.matcher(password);

    return matcher.matches();
  }
}