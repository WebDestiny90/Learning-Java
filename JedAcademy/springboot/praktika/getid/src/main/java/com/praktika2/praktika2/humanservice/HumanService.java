package com.praktika2.praktika2.humanservice;

import com.praktika2.praktika2.dto.HumanRegisterDto;
import com.praktika2.praktika2.entity.HumanEntity;
import com.praktika2.praktika2.repository.HumanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HumanService {
  private final HumanRepository repository;

  public String UserRegister(HumanRegisterDto dto){

    HumanEntity entity = new HumanEntity(dto.getId(), dto.getName(), dto.getSurname(), dto.getAge());
    repository.save(entity);
    return "Register Successfully!" + entity.getName();
  }

  public List<HumanEntity> humanList(){
    return repository.findAll();
  }

  public HumanEntity getById(Long id){
    return repository.findById(id);
  }

}
