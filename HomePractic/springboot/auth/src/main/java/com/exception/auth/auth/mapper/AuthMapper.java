package com.exception.auth.auth.mapper;

import com.exception.auth.auth.dao.entity.AuthEntity;
import com.exception.auth.auth.dto.AuthRequestDto;
import com.exception.auth.auth.dto.AuthResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

  AuthEntity toDto(AuthRequestDto authRequestDto);

  AuthResponseDto toEntity(AuthEntity authEntity);
}
