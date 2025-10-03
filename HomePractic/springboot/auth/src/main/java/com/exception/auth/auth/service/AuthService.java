package com.exception.auth.auth.service;

import com.exception.auth.auth.dao.repository.AuthRepository;
import com.exception.auth.auth.dto.AuthRequestDto;
import com.exception.auth.auth.dto.AuthResponseDto;
import com.exception.auth.auth.dto.PasswordValidator;
import com.exception.auth.auth.exception.InvalidPasswordException;
import com.exception.auth.auth.mapper.AuthMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final AuthRepository authRepository;
  private final AuthMapper authMapper;

  @Transactional
  public void addAuth(AuthRequestDto authRequestDto){
    authRepository.save(authMapper.toDto(authRequestDto));

    if (!PasswordValidator.isValidPassword(authRequestDto.getPassword())){
      throw new InvalidPasswordException("Passwordun invaliddi");
    }
  }

}
