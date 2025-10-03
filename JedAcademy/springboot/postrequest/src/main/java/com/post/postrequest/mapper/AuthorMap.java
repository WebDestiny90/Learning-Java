package com.post.postrequest.mapper;

import com.post.postrequest.dao.entity.AuthorEntity;
import com.post.postrequest.dto.v2.AuthorResponse;
import com.post.postrequest.dto.v2.AuthorResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorMap {


  public AuthorResponse entityToDto(AuthorEntity e) {
    String fname = e.getFname() + " " + e.getLname();
    return new AuthorResponse(e.getNick(), e.getId(), fname);
  }

  public List<AuthorResponse> entityListToDto(List<AuthorEntity> l) {
    List<AuthorResponse> finalVers = new ArrayList<>();
    for (AuthorEntity x : l) {
      finalVers.add(entityToDto(x));
    }

    return finalVers;


  }
}
