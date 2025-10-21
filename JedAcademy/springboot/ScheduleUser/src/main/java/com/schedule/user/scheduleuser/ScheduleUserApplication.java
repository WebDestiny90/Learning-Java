package com.schedule.user.scheduleuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScheduleUserApplication {

  public static void main(String[] args) {
    SpringApplication.run(ScheduleUserApplication.class, args);
  }

}
