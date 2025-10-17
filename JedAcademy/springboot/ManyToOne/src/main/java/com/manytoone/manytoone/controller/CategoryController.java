package com.manytoone.manytoone.controller;

import com.manytoone.manytoone.Service.CategoryService;
import com.manytoone.manytoone.dto.CategoryRequestDto;
import com.manytoone.manytoone.dto.CategoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
  private final CategoryService categoryService;

  @PostMapping("/add")
  public Long addCategory(@RequestBody CategoryRequestDto requestDto) {
    return categoryService.addCategory(requestDto);
  }

  @GetMapping("/{id}")
  public CategoryResponseDto getCategoryById(@PathVariable Long id) {
    return categoryService.getCategoryById(id);
  }
}
