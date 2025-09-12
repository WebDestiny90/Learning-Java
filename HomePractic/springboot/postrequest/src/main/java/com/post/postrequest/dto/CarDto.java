package com.post.postrequest.dto;

import com.post.postrequest.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
  private String model;
  private String mark;
  private String year;
  private String engine;
  private String price;
  private Color color;
}
