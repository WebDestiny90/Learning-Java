package com.practice.openfeign.productclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProductClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProductClientApplication.class, args);
  }

}
