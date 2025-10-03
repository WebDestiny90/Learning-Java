package com.post.postrequest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HumanDto {
  private String first_name;
  private String last_name;
  private Integer age;
}
