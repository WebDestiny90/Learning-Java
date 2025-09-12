package com.praktika.praktika1.controller;

import com.praktika.praktika1.dto.HumanRegisterRequestDto;
import com.praktika.praktika1.entity.HumanEntity;
import com.praktika.praktika1.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/human")
@RequiredArgsConstructor
public class HumanController {
  private final HumanService service;

  @PostMapping("/add")
  public String userRegister(@RequestBody HumanRegisterRequestDto dto) {
    return service.UserRegister(dto);
  }
  @PostMapping("/get")
  public List<HumanEntity> getUsers() {
    return service.humanList();
  }

  @PostMapping("/get/{id}")
  public HumanEntity getById(@PathVariable("id") Long id) {
    return service.getById(id);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteById(@PathVariable("id") Long id) {
    return service.deleteUser(id);
  }
}
