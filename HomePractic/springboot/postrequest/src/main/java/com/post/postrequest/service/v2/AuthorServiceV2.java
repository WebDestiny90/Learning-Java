//package com.post.postrequest.service.v2;
//
//import com.post.postrequest.dao.repository.AuthorRepository;
//import com.post.postrequest.dto.v2.AuthorRequest;
//import com.post.postrequest.dto.v2.AuthorResponse;
//import com.post.postrequest.dto.v2.AuthorResponseDto;
//import com.post.postrequest.mapper.AuthorMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
/// /@Service
/// /@RequiredArgsConstructor
/// /public class AuthorServiceV2 {
/// /  private final AuthorRepository authorRepository;
/// /  private final AuthorMapper authorMapper;
/// /
/// /  public List<AuthorResponseDto> getAuthors() {
/// /    var entityList = authorRepository.findAll();
/// /    return authorMapper.entityListToDtoList(entityList);
/// /
/// /  }
/// /
/// /  public List<AuthorResponse> getAuthorsResponse(AuthorRequest request) {
/// /    var eList = authorRepository.findAllByUpdatedAt(request.updated_at());
/// /    return authorMapper.entityListToRecordList(eList);
/// /  }
/// /
/// /}
