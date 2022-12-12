package com.kpi.omelian.booking_service;


import com.kpi.omelian.booking_service.entity.dto.SessionDto;
import com.kpi.omelian.booking_service.service.SessionService;
import java.time.LocalDateTime;
import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@EnableAspectJAutoProxy
public class BookingServiceApplication implements CommandLineRunner {

	@Autowired
  private SessionService service;

  public static void main(String[] args) {
    SpringApplication.run(BookingServiceApplication.class, args);
  }

  @Override
  public void run(String... args) {
    LocalDateTime startDate = LocalDateTime.of(2025, Month.AUGUST, 12, 12, 0);
    LocalDateTime endDate = LocalDateTime.of(2025, Month.AUGUST, 12, 13, 0);
    SessionDto sessionDto = SessionDto.builder()
      .movieId(1L)
      .cinemaId(1L)
      .hallId(1L)
      .startTime(startDate)
      .endTime(endDate)
      .build();
    service.save(sessionDto);
  }

}
