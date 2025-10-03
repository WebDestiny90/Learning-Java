package com.praktika2.praktika2.entity;

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

}
