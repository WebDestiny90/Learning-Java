package com.user.page.pagination.service;

import com.user.page.pagination.dao.entity.UserClientEntity;
import com.user.page.pagination.dao.repository.UserClientRepository;
import com.user.page.pagination.dto.UserClientRequestDto;
import com.user.page.pagination.mapper.UserClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserClientService {
  private final UserClientRepository userClientRepository;
  private final UserClientMapper userClientMapper;

  public void addUser(UserClientRequestDto userClientRequestDto) {
    userClientRepository.save(userClientMapper.dtoToEntity(userClientRequestDto));
  }

  public Page<UserClientEntity> getUsers(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return userClientRepository.findAll(pageable);
  }
}
