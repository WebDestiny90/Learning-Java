package com.reservation.carreservation.client;

import com.reservation.carreservation.dto.CarFilterDto;
import com.reservation.carreservation.dto.CarResponseDto;
import com.reservation.carreservation.dto.PageResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cars-service", url = "${cars-service.url}")
public interface CarServiceFeignClient {

    @GetMapping("/get")
    ResponseEntity<PageResponse<CarResponseDto>> getCars(@SpringQueryMap CarFilterDto filterDto);

    @PostMapping("/{id}/reserve")
    ResponseEntity<CarResponseDto> reserveCar(@PathVariable Long id);
}