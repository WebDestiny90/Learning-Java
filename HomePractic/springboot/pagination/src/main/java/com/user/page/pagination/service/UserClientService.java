package com.user.page.pagination.service;

import com.user.page.pagination.dao.entity.UserClientEntity;
import com.user.page.pagination.dao.repository.UserClientRepository;
import com.user.page.pagination.dto.UserClientRequestDto;
import com.user.page.pagination.dto.UserClientResponseDto;
import com.user.page.pagination.mapper.UserClientMapper;
import com.user.page.pagination.specification.UserClientSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class  UserClientService {
  private final UserClientRepository userClientRepository;
  private final UserClientMapper userClientMapper;

  public void addUser(UserClientRequestDto userClientRequestDto) {
    userClientRepository.save(userClientMapper.dtoToEntity(userClientRequestDto));
  }

  public Page<UserClientResponseDto> getUsers(int page, int size, String fullName, String surName) {
    Pageable pageable = PageRequest.of(page, size);

    Specification<UserClientEntity> spec = Specification.allOf(
            UserClientSpecification.hasName(fullName),
            UserClientSpecification.hasSurName(surName)
    );

    Page<UserClientEntity> users = userClientRepository.findAll(spec, pageable);
    return users.map(userClientMapper::toDto);
  }
}
