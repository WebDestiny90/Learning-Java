package com.post.postrequest.service;


import com.post.postrequest.dao.entity.UsersEntity;
import com.post.postrequest.dao.repository.UsersRepository;
import com.post.postrequest.dto.UsersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
  private final UsersRepository usersRepository;

  public List<UsersEntity> getUsers() {
    return usersRepository.findAll();
  }

  public Long addUser(UsersDto usersDto) {
    var userEntity = new UsersEntity(usersDto.getFull_name(), usersDto.getLast_name(), usersDto.getAge());
    usersRepository.save(userEntity);
    return userEntity.getId();
  }

  public UsersEntity updateUser(UsersDto usersDto, Long id) {
    var userEntity = usersRepository.findById(id).get();
    userEntity.setFull_name(usersDto.getFull_name());
    userEntity.setLast_name(usersDto.getLast_name());
    userEntity.setAge(usersDto.getAge());
    usersRepository.save(userEntity);
    return userEntity;
  }

  public void deleteUser(Long id) {
    usersRepository.deleteById(id);
  }
}
