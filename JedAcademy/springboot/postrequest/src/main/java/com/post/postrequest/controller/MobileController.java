package com.post.postrequest.controller;

import com.post.postrequest.OsEnum;
import com.post.postrequest.dao.entity.MobileEntity;
import com.post.postrequest.dto.MobileDto;
import com.post.postrequest.dto.MobileEsimDto;
import com.post.postrequest.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mobile")
@RequiredArgsConstructor
public class MobileController {
  private final MobileService mobileService;

  @GetMapping
  public List<MobileEntity> getMobile() {
    return mobileService.getMobile();
  }

  //  @PostMapping
  //  public Long addMobile(@RequestBody MobileDto mobileDto) {
  //    return mobileService.addMobile(mobileDto);
  //  }

  @DeleteMapping("{id}")
  public void deleteMobile(@PathVariable("id") Long id) {
    mobileService.deleteMobile(id);
  }

  @GetMapping("/esim")
  public List<MobileEntity> getEsimMobiles() {
    return mobileService.getMobilesWithEsim();
  }

  @GetMapping("/os")
  public List<MobileEsimDto> getMobileOs() {
    return mobileService.getMobileOs();
  }
}
