package com.redis.user.userredis.service;

import com.redis.user.userredis.dao.repository.CustomerRepository;
import com.redis.user.userredis.dto.CustomerRequestDto;
import com.redis.user.userredis.dto.CustomerResponseDto;
import com.redis.user.userredis.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
  private static final String CUSTOMER_PREFIX = "Customer: ";
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;
  private final RedisService redisService;

  public void addCustomer(CustomerRequestDto requestDto) {
    var customer = customerRepository.save(customerMapper.requestDtoToEntity(requestDto));
    CustomerResponseDto responseDto = customerMapper.responseToDto(customer);
    redisService.setValue(CUSTOMER_PREFIX + customer.getId(), responseDto);
  }

  public void addCustomers(List<CustomerRequestDto> requestDtoList) {
    var customers = customerRepository.saveAll(customerMapper.requestListToDtoEntity(requestDtoList));
    List<CustomerResponseDto> responseDtoList = customerMapper.responseListToDto(customers);
    redisService.setValue(CUSTOMER_PREFIX, responseDtoList);
  }

  public List<CustomerResponseDto> getCustomers() {
    var redisDatas = redisService.getValue(CUSTOMER_PREFIX);
    if (redisDatas != null) {
      log.info("Data loaded from Redis");
      return (List<CustomerResponseDto>) redisDatas;
    }
    log.info("Data loaded from Repository:");
    var entity = customerRepository.findAll();
    List<CustomerResponseDto> customers = customerMapper.responseListToDto(entity);
    redisService.setValue(CUSTOMER_PREFIX, customers);
    return customers;
  }

  public CustomerResponseDto getUserById(Long id) {
    var redisData = redisService.getValue(CUSTOMER_PREFIX + id);
    if (redisData != null) {
      log.info("Data from redis: {}", id);
      return (CustomerResponseDto) redisData;
    }
    log.info("Data Loaded From Repository: (miss cache) {}", id);
    var entity = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found with ID:" + id));
    CustomerResponseDto customer = customerMapper.responseToDto(entity);
    redisService.setValue(CUSTOMER_PREFIX, customer);
    return customer;
  }
}
