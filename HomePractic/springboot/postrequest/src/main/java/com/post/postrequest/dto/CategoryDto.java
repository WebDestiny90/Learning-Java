package com.post.postrequest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
  private String categoryName;
  //  @JsonIgnore
  private String title;
  private String description;
  private List<NewsDto> news;

  public CategoryDto(String categoryName, String title, String description) {
    this.categoryName = categoryName;
    this.title = title;
    this.description = description;
  }
}
