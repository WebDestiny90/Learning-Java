package com.post.postrequest.controller.v2;


import com.post.postrequest.dto.v2.AuthorRequest;
import com.post.postrequest.dto.v2.AuthorResponse;
import com.post.postrequest.dto.v2.AuthorResponseDto;
import com.post.postrequest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/author")
@RequiredArgsConstructor
public class AuthorControllerV2 {
  //  private final AuthorServiceV2 authorServiceV2;
  private final AuthorService old;
  //
  //  @GetMapping
  //  public List<AuthorResponseDto> getAuthor() {
  //    return authorServiceV2.getAuthors();
  //  }
  //
  //  @PostMapping("/updated/list")
  //  public List<AuthorResponse> getUpdatedAuthorList(@RequestBody AuthorRequest request) {
  //    return authorServiceV2.getAuthorsResponse(request);
  //  }

  @GetMapping("/getby/{id}")
  public AuthorResponse getById(@PathVariable("id") Long id) {
    return old.authorGetById(id);
  }
}
