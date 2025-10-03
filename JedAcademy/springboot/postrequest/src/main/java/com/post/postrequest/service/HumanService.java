package com.post.postrequest.service;

import com.post.postrequest.dao.entity.HumanEntity;
import com.post.postrequest.dao.repository.HumanRepository;
import com.post.postrequest.dto.HumanDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HumanService {
  private final HumanRepository humanRepository;

  public List<HumanEntity> getHuman() {
    return humanRepository.findAll();
  }

  public Long addHuman(HumanDto humanDto) {
    var humans = new HumanEntity(humanDto.getFirst_name(), humanDto.getLast_name(), humanDto.getAge());

    humanRepository.save(humans);
    return humans.getId();
  }

  public HumanEntity updateHuman(HumanDto humanDto, Long id) {
    var humanEntity = humanRepository.findById(id).get();

    humanEntity.setFirst_name(humanDto.getFirst_name());
    humanEntity.setLast_name(humanDto.getLast_name());
    humanEntity.setAge(humanDto.getAge());
    humanRepository.save(humanEntity);
    return humanEntity;
  }

  public void deleteHuman(Long id) {
    humanRepository.deleteById(id);
  }
}
