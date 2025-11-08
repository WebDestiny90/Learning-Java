package com.reservation.carreservation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "car-service", url = "http://localhost:8080/api/v1/car")
public interface CarFeignClient {

    @GetMapping("/{id}/available")
    Boolean isCarAvailable(@PathVariable("id") Long carId);
}
