package com.post.postrequest.controller;

import com.post.postrequest.dao.repository.CategoryRepository;
import com.post.postrequest.dto.CategoryDto;
import com.post.postrequest.service.CategoryServcice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
  private final CategoryServcice categoryServcice;
  private final CategoryRepository categoryRepository;

  @GetMapping
  public List<CategoryDto> getCategories() {
    return categoryServcice.getCategoryList();
  }

  @GetMapping("/native/{id}")
  public List<CategoryDto> getCategoriesNative(@PathVariable("id") Long id) {
    return categoryRepository.findForDestiny(id);
  }

  @GetMapping("/single")
  public CategoryDto getSomeCategory(@RequestParam("id") Long id) {
    return categoryServcice.getSomeCategory(id);
  }

  @PutMapping("/{id}")
  public void updateCategory(@RequestParam("name") String name, @PathVariable("id") Long id) {
    categoryServcice.updateCategory(name, id);
  }
}
