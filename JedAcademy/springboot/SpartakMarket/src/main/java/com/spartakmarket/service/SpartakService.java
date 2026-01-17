package com.spartakmarket.service;

import com.spartakmarket.dto.SpartakRequestDto;
import com.spartakmarket.dto.SpartakResponseDto;

import java.util.List;

public interface SpartakService {
    SpartakResponseDto createUser(SpartakRequestDto dto);
    List<SpartakResponseDto> getAllUsers();
}
