package com.post.postrequest.controller;

import com.post.postrequest.dao.entity.HumanEntity;
import com.post.postrequest.dto.HumanDto;
import com.post.postrequest.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/humans")
@RequiredArgsConstructor
public class HumanController {
  private final HumanService humanService;

  @GetMapping
  public List<HumanEntity> getHuman() {
    return humanService.getHuman();
  }

  @PostMapping
  public Long addHuman(@RequestBody HumanDto humanDto) {
    return humanService.addHuman(humanDto);
  }

  @PatchMapping("{id}")
  public HumanEntity updateHuman(@RequestBody HumanDto humanDto, @PathVariable("id") Long id) {
    return humanService.updateHuman(humanDto, id);
  }

  @DeleteMapping("{id}")
  public void deleteHuman(@PathVariable("id") Long id) {
    humanService.deleteHuman(id);
  }
}
