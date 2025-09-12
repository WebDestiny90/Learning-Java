package com.post.postrequest.dto.v2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorResponseDto {
  private Long id;
  private String fullName;
  private String nick;
}
