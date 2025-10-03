//package com.spring.manytoone.onetomany.mapper;
//
//import com.spring.manytoone.onetomany.dao.entity.AddressEntity;
//import com.spring.manytoone.onetomany.dao.entity.UserEntity;
//import com.spring.manytoone.onetomany.dto.UserResponseDto;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//import org.mapstruct.factory.Mappers;
//
//
//@Mapper(componentModel = "spring")
//public interface UserMapper {
//  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
//
//  @Mapping(source = "address",target = "userAddress",qualifiedByName = "getAddress")
//  UserResponseDto toDto(UserEntity userEntity);
//
//  @Named("getAddress")
//  default String address(AddressEntity address){
//    if (address ==null) {
//      return "No address";
//    }
//    return address.getCity()+ ", " + address.getStreet();
//  }
//}
