package com.user.page.pagination.mapper;

import com.user.page.pagination.dao.entity.UserClientEntity;
import com.user.page.pagination.dto.UserClientRequestDto;
import com.user.page.pagination.dto.UserClientResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserClientMapper {
  UserClientEntity dtoToEntity(UserClientRequestDto userClientRequestDto);

  List<UserClientResponseDto> toDto(List<UserClientEntity> userClientEntities);
}
