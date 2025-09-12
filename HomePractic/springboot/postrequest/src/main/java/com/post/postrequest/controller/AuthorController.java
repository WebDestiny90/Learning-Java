package com.post.postrequest.controller;


import com.post.postrequest.dao.entity.AuthorEntity;
import com.post.postrequest.dto.AuthorDto;
import com.post.postrequest.dto.v2.AuthorResponse;
import com.post.postrequest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/author")
public class AuthorController {
  private final AuthorService service;

  @GetMapping
  public List<AuthorResponse> getAuthors() {
    return service.getAuthors();
  }

  @PostMapping
  public Long addAuthors(@RequestBody AuthorDto authorDto) {
    return service.addAuthor(authorDto);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthor(@PathVariable Long id) {
    service.deleteAuthor(id);
  }

  @PatchMapping("/{id}")
  public AuthorEntity updateAuthor(@RequestBody AuthorDto authorDto, @PathVariable("id") Long id) {
    return service.updateAuthor(authorDto, id);

  }
}
