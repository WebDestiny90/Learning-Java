package com.comebackpraktika.service;

import com.comebackpraktika.dao.entity.ComebackEntity;
import com.comebackpraktika.dao.repository.ComebackRepository;
import com.comebackpraktika.dto.ComebackRequestDto;
import com.comebackpraktika.dto.ComebackResponseDto;
import com.comebackpraktika.dto.TransferRequest;
import com.comebackpraktika.exception.InsufficientBalanceException;
import com.comebackpraktika.exception.NotFoundException;
import com.comebackpraktika.exception.SameIdException;
import com.comebackpraktika.exception.WrongAmountException;
import com.comebackpraktika.mapper.ComebackMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComebackService {
  private final ComebackRepository comebackRepository;
  private final ComebackMapper comebackMapper;

  public Long addUser(ComebackRequestDto requestDto) {
    return comebackRepository.save(comebackMapper.toEntity(requestDto)).getId();
  }

  public List<Long> addUsers(List<ComebackRequestDto> requestDtoList) {
    var users = comebackRepository.saveAll(comebackMapper.toEntityList(requestDtoList));
    return users.stream().map(ComebackEntity::getId).toList();
  }

  public ComebackResponseDto getUserById(Long id) {
    return comebackMapper.toDto(comebackRepository.findById(id)

            .orElseThrow(() -> new RuntimeException("user not found by id" + id)));
  }

  public List<ComebackResponseDto> getUsers() {
    return comebackRepository.findAllByDeletedFalse().stream().map(comebackMapper::toDto).toList();
  }

  public ComebackResponseDto updateUser(ComebackRequestDto requestDtoUpdate, Long id) {
    var update = comebackRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found by id:" + id));
    update.setFirstName(requestDtoUpdate.getFirstName());
    update.setSurName(requestDtoUpdate.getSurName());
    var save = comebackRepository.save(update);
    return comebackMapper.toDto((save));
  }

  public String deleteUser(Long id) {
    if (!comebackRepository.existsById(id)) {
      throw new RuntimeException("user not found by id:" + id);
    }
    comebackRepository.deleteById(id);

    return "User Deleted successfully with id: " + id;
  }

  public String softDeleteUser(Long id) {
    var user = comebackRepository.findByIdAndDeletedFalse(id)
            .orElseThrow(() -> new RuntimeException("User not found by id: " + id));

    user.setDeleted(true);

    comebackRepository.save(user);

    return "User soft deleted successfully with id: " + id;
  }

  @Transactional
  public String transferMoney(TransferRequest request) {

    var sender = comebackRepository.findByIdAndDeletedFalse(request.getSenderId())
            .orElseThrow(() -> new NotFoundException("Sender not found"));

    var receiver = comebackRepository.findByIdAndDeletedFalse(request.getReceiverId())
            .orElseThrow(() -> new NotFoundException("Receiver not found"));

    if(request.getAmount() == null || request.getAmount() <= 0) {
      throw new WrongAmountException("Invalid transfer amount.");
    }

    if (sender.getId().equals(receiver.getId())) {
      throw new SameIdException("Sender and receiver cannot be the same user.");
    }

    if (sender.getBalance() < request.getAmount()) {
      throw new InsufficientBalanceException("Insufficient balance.");
    }


    sender.setBalance(sender.getBalance() - request.getAmount());
    receiver.setBalance(receiver.getBalance() + request.getAmount());

    comebackRepository.save(sender);
    comebackRepository.save(receiver);

    return "Transfer successfully: " +  request.getAmount() + " Balance: " + sender.getBalance();
  }
}