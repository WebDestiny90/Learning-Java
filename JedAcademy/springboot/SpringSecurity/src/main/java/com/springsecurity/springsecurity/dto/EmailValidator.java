package com.springsecurity.springsecurity.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

  public static boolean isValidEmail(String email) {
    String regExpn = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    Pattern pattern = Pattern.compile(regExpn);
    Matcher matcher = pattern.matcher(email);

    return matcher.matches();
  }
}