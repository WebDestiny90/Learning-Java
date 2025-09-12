package com.praktika.praktika1.entity;

import com.praktika.praktika1.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HumanEntity {
  private Long id;
  private String name;
  private String surname;
  private Integer age;
  private Gender gender;

}
