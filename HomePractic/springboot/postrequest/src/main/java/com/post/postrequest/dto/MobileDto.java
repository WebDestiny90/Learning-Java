package com.post.postrequest.dto;

import com.post.postrequest.Color;
import com.post.postrequest.OsEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileDto {
  private String mark;
  private String model;
  private int year;
  private OsEnum oS;
  private Color color;
  private boolean esim_support;
}
