package com.manytoone.manytoone.Service;

import com.manytoone.manytoone.dao.repository.CategoryRepository;
import com.manytoone.manytoone.dto.CategoryRequestDto;
import com.manytoone.manytoone.dto.CategoryResponseDto;
import com.manytoone.manytoone.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;

  public Long addCategory(CategoryRequestDto requestDto) {
    var categoryEntity = categoryMapper.RequestDtoToEntity(requestDto);

    if (categoryEntity.getProducts() != null) {
      categoryEntity.getProducts().forEach(p -> p.setCategory(categoryEntity));
    }

    var saved = categoryRepository.save(categoryEntity);
    return saved.getId();
  }

  public CategoryResponseDto getCategoryById(Long id) {
    return categoryMapper.EntityToResponseDto(categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found")));
  }
}
