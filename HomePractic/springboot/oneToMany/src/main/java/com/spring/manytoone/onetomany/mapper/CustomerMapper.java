//package com.spring.manytoone.onetomany.mapper;
//
//import com.spring.manytoone.onetomany.dao.entity.CustomerEntity;
//import com.spring.manytoone.onetomany.dao.entity.OrderEntity;
//import com.spring.manytoone.onetomany.dto.CustomerResponseDto;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Named;
//import org.mapstruct.factory.Mappers;
//
//
//@Mapper(componentModel = "spring")
//public interface CustomerMapper {
//  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
//
//  @Mapping(source = "customer",target = "userOrder",qualifiedByName = "getOrders")
//  CustomerResponseDto toDto(CustomerEntity customerEntity);
//
//  @Named("getOrders")
//  default String orders(OrderEntity orderEntity){
//    if (orderEntity ==null) {
//      return "No Order";
//    }
//    return orderEntity.getOrderName()+ ", " + orderEntity.getOrderPrice();
//  }
//}
