package com.post.postrequest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class NewsDto {
  private String title;
  private String description;
}
