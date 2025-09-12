//package com.post.postrequest.mapper;
//
//import com.post.postrequest.dao.entity.AuthorEntity;
//import com.post.postrequest.dto.v2.AuthorResponse;
//import com.post.postrequest.dto.v2.AuthorResponseDto;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class AuthorMapper {
//  public List<AuthorResponseDto> entityListToDtoList(List<AuthorEntity> list) {
//    List<AuthorResponseDto> response = new ArrayList<>();
//
//    for (AuthorEntity a : list) {
//      response.add(entityToDto(a));
//    }
//    return response;
//  }
//
//  public AuthorResponseDto entityToDto(AuthorEntity entity) {
//    return AuthorResponseDto.builder().id(entity.getId()).fullName(entity.getFname() + " " + entity.getLname()).nick(entity.getNick()).build();
//  }
//
//  public AuthorResponse entityToRecord(AuthorEntity ae) {
//    return new AuthorResponse(ae.getNick());
//  }
//
//  public List<AuthorResponse> entityListToRecordList(List<AuthorEntity> ae) {
//    List<AuthorResponse> response = new ArrayList<>();
//
//    for (AuthorEntity a : ae) {
//      response.add(entityToRecord(a));
//    }
//    return response;
//  }
//}
