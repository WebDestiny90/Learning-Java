package com.spartakmarket.service;

import com.spartakmarket.dao.entity.SpartakEntity;
import com.spartakmarket.dao.repository.SpartakRepository;
import com.spartakmarket.dto.SpartakRequestDto;
import com.spartakmarket.dto.SpartakResponseDto;
import com.spartakmarket.mapper.SpartakMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpartakServiceImpl implements SpartakService {

    private final SpartakRepository repository;
    private final SpartakMapper mapper;

    @Override
    public SpartakResponseDto createUser(SpartakRequestDto dto) {
        SpartakEntity entity = mapper.requestDtoToEntity(dto);
        SpartakEntity saved = repository.save(entity);
        return mapper.entityToResponseDto(saved);
    }

    @Override
    public List<SpartakResponseDto> getAllUsers() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToResponseDto)
                .toList();
    }
}
