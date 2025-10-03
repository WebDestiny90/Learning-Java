package com.praktika2.praktika2.controller;

import com.praktika2.praktika2.entity.HumanEntity;
import com.praktika2.praktika2.humanservice.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/human")
@RequiredArgsConstructor
public class HumanController {
  private final HumanService service;

  @PostMapping("/get/{id}")
  public HumanEntity getById(@PathVariable("id") Long id) {
    return service.getById(id);
  }
}
