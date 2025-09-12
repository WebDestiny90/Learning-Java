package com.post.postrequest.mapper;

import com.post.postrequest.dao.entity.CategoryEntity;
import com.post.postrequest.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
  public CategoryDto entityToDto(CategoryEntity category) {
    return CategoryDto.builder().categoryName(category.getCategoryName()).build();
  }
}
