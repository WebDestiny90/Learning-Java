package com.spring.order.customerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CustomerserverApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerserverApplication.class, args);
  }

}
