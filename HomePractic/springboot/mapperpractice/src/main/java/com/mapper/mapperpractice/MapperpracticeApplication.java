package com.mapper.mapperpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MapperpracticeApplication {

  public static void main(String[] args) {
    SpringApplication.run(MapperpracticeApplication.class, args);
  }

}
