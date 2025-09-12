package com.post.postrequest.controller;


import com.post.postrequest.dao.entity.UsersEntity;
import com.post.postrequest.dto.UsersDto;
import com.post.postrequest.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {
  private final UsersService usersService;

  @GetMapping
  public List<UsersEntity> getUsers() {
    return usersService.getUsers();
  }

  @PostMapping
  public Long addUser(@RequestBody UsersDto usersDto) {
    return usersService.addUser(usersDto);
  }

  @PatchMapping("{id}")
  public UsersEntity updateUser(@RequestBody UsersDto usersDto, @PathVariable("id") Long id) {
    return usersService.updateUser(usersDto, id);
  }

  @DeleteMapping("{id}")
  public void deleteUser(@PathVariable("id") Long id) {
    usersService.deleteUser(id);
  }

}
