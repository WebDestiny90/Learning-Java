package com.post.postrequest.service;

import com.post.postrequest.dao.entity.CategoryEntity;
import com.post.postrequest.dao.entity.NewsEntity;
import com.post.postrequest.dao.repository.CategoryRepository;
import com.post.postrequest.dao.repository.NewsRepository;
import com.post.postrequest.dto.CategoryDto;
import com.post.postrequest.dto.NewsDto;
import com.post.postrequest.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServcice {
  private final CategoryRepository categoryRepository;
  private final NewsRepository newsRepository;
  private final CategoryMapper categoryMapper;

  public List<CategoryDto> getCategoryList() {
    List<CategoryDto> result = new ArrayList<>();
    var categoryList = categoryRepository.findAll();

    for (CategoryEntity c : categoryList) {
      var news = newsRepository.findAllByCategoryId(c.getId());
      var resultCategoryDto = CategoryDto.builder().categoryName(c.getCategoryName()).news(getNewsDto(news)).build();
      result.add(resultCategoryDto);
    }
    return result;
  }

  public List<NewsDto> getNewsDto(List<NewsEntity> newsEntityList) {
    List<NewsDto> result = new ArrayList<>();
    for (NewsEntity n : newsEntityList) {
      var news = NewsDto.builder().title(n.getTitle()).description(n.getDescription()).build();
      result.add(news);
    }
    return result;
  }

  public CategoryDto getSomeCategory(Long id) {
    //    var category = categoryRepository.findSomeCategory(id);
    //    if (category.isPresent()) {
    //      var c = category.get();
    //      return categoryMapper.entityToDto(c);
    //    }
    //    return new CategoryDto();
    var category = categoryRepository.findSomeCategory(id).orElse(new CategoryEntity());

    return categoryMapper.entityToDto(category);
  }

  public void updateCategory(String name, Long id) {
    categoryRepository.updateSomeCategory(name, id);
  }
}
