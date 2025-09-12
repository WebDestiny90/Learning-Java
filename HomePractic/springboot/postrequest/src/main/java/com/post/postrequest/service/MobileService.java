package com.post.postrequest.service;

import com.post.postrequest.OsEnum;
import com.post.postrequest.dao.entity.MobileEntity;
import com.post.postrequest.dao.repository.MobileRepository;
import com.post.postrequest.dto.MobileDto;
import com.post.postrequest.dto.MobileEsimDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MobileService {
  private final MobileRepository mobileRepository;

  public List<MobileEntity> getMobile() {
    return mobileRepository.findAll();
  }

  //  public Long addMobile(MobileDto mobileDto) {
  //    var mobileEntity = new MobileEntity(mobileDto.getMark(), mobileDto.getModel(), mobileDto.getYear(), mobileDto.getOs_version(), mobileDto.getColor(), true);
  //    MobileEntity entity = mobileRepository.save(mobileEntity);
  //    return entity.getId();
  //  }

  public void deleteMobile(Long id) {
    mobileRepository.deleteById(id);
  }


  public List<MobileEntity> getMobilesWithEsim() {
    return mobileRepository.findByEsimSupportIsTrue();
  }

  public List<MobileEsimDto> getMobileOs() {

    List<MobileEsimDto> dtos = new ArrayList<>();
    for (MobileEntity e : mobileRepository.findAll()) {
      MobileEsimDto dto = new MobileEsimDto();
      dto.setOS(e.getOS());
      dtos.add(dto);
    }

    return dtos;
  }
}