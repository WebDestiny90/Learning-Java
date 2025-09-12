package com.praktika.praktika1.service;

import com.praktika.praktika1.dto.HumanRegisterRequestDto;
import com.praktika.praktika1.entity.HumanEntity;
import com.praktika.praktika1.repository.HumanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HumanService {
  private final HumanRepository repository;

  public String UserRegister(HumanRegisterRequestDto dto){
    if(dto.getAge() < 18) {
      throw new RuntimeException("Age must be greater than 18");
    }

    if(dto.getId().equals(null)
            || dto.getName().equals(null)
            || dto.getSurname().equals(null)
            || dto.getId().equals(null)
            || dto.getGender().equals(null)) {
      throw new RuntimeException("Invalid Input");
    }
    HumanEntity entity = new HumanEntity(dto.getId(), dto.getName(), dto.getSurname(), dto.getAge(), dto.getGender());
    repository.save(entity);
    return "Register Successfully!" + entity.getName();
  }

  public List<HumanEntity> humanList(){
    return repository.findAll();
  }

  public HumanEntity getById(Long id){
    return repository.findById(id);
  }

  public String deleteUser(Long id){
    var entity = repository.findById(id);
    repository.delete(entity.getId());
    return "Delete Successfully!" +entity.getName();
  }
}
