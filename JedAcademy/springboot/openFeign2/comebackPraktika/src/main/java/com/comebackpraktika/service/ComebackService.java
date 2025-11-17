package com.comebackpraktika.service;

import com.comebackpraktika.dao.entity.ComebackEntity;
import com.comebackpraktika.dao.repository.CamebackRepository;
import com.comebackpraktika.dto.ComebackRequestDto;
import com.comebackpraktika.dto.ComebackResponseDto;
import com.comebackpraktika.mapper.ComebackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComebackService {
  private final CamebackRepository camebackRepository;
  private final ComebackMapper comebackMapper;

  public Long addUser(ComebackRequestDto requestDto) {
    return camebackRepository.save(comebackMapper.toEntity(requestDto)).getId();
  }

  public List<Long> addUsers(List<ComebackRequestDto> requestDtoList) {
    var users = camebackRepository.saveAll(comebackMapper.toEntityList(requestDtoList));
    return users.stream().map(ComebackEntity::getId).toList();
  }

  public ComebackResponseDto getUserById(Long id) {
    return comebackMapper.toDto(camebackRepository.findById(id)

            .orElseThrow(() -> new RuntimeException("user not found by id" + id)));
  }

  public List<ComebackResponseDto> getUsers() {
    return camebackRepository.findAll().stream().map(comebackMapper::toDto).toList();
  }

  public ComebackResponseDto updateUser(ComebackRequestDto requestDtoUpdate, Long id) {
    var update = camebackRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found by id:" + id));
    update.setFirstName(requestDtoUpdate.getFirstName());
    update.setSurName(requestDtoUpdate.getSurName());
    var save = camebackRepository.save(update);
    return comebackMapper.toDto((save));
  }

  public String deleteUser(Long id) {
    if (!camebackRepository.existsById(id)) {
      throw new RuntimeException("user not found by id:" + id);
    }
    camebackRepository.deleteById(id);

    return "User Deleted successfully with id: " + id;
  }
}
