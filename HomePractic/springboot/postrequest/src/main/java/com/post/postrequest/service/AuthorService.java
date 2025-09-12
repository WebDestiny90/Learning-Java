package com.post.postrequest.service;

import com.post.postrequest.dao.entity.AuthorEntity;
import com.post.postrequest.dao.repository.AuthorRepository;
import com.post.postrequest.dto.AuthorDto;
import com.post.postrequest.dto.v2.AuthorResponse;
import com.post.postrequest.mapper.AuthorMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
  private final AuthorRepository repository;
  private final AuthorMap map;

  public List<AuthorResponse> getAuthors() {
    return map.entityListToDto(repository.findAll());
  }

  public Long addAuthor(AuthorDto authorDto) {
    var authors = new AuthorEntity(authorDto.getFname(), authorDto.getLname(), authorDto.getNick());

    AuthorEntity e = repository.save(authors);
    return e.getId();
  }

  public AuthorEntity updateAuthor(AuthorDto dto, Long id) {
    var authorEntity = repository.findById(id).get();
    authorEntity.setLname(dto.getLname());
    authorEntity.setFname(dto.getFname());
    authorEntity.setNick(dto.getNick());
    repository.save(authorEntity);
    return authorEntity;
  }

  public void deleteAuthor(Long id) {
    repository.deleteById(id);
  }


  public AuthorResponse xnxx(Long id) {
    AuthorEntity x = repository.findById(id).get();

    return map.entityToDto(x);
  }
}

