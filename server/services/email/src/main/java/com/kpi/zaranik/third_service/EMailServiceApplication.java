package com.kpi.zaranik.third_service;

import java.util.concurrent.TimeUnit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class EMailServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(EMailServiceApplication.class, args);
  }


}
