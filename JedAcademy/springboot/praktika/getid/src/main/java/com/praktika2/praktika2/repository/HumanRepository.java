package com.praktika2.praktika2.repository;

import com.praktika2.praktika2.entity.HumanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Repository
public class HumanRepository {
  private List<HumanEntity> humans = new ArrayList<>();

  public void save(HumanEntity entity){
    humans.add(entity);
  }

  public List<HumanEntity> findAll(){
    return humans;
  }

  public HumanEntity findById(Object id){
    return humans.stream().filter((i)->i.getId().equals(id)).findFirst().orElseThrow(()-> new RuntimeException("User not found"));
  }
}
