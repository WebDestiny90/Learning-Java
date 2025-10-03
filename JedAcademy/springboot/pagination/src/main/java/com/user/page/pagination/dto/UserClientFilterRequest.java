package com.user.page.pagination.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserClientFilterRequest {
  String fullName;
  String lastName;
  String email;
  Integer page=0;
  Integer size=5;
}
