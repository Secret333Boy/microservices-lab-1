package com.example.demo.controllers;

import com.example.demo.services.AverageResponseTimeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request-service")
public class AverageResponseTimeController {

  @Autowired
  private AverageResponseTimeCalculator averageResponseTimeCalculator;

  @Value("${auth.service.url}")
  private String authServiceUrl;

  @Value("${jsonplaceholder.service.url}")
  private String jsonPlaceholderServiceUrl;

  @GetMapping("/get-avg-time/jsonplaceholder")
  public Double performRequestToJsonPlaceholderService(@RequestParam Long count) {
    return averageResponseTimeCalculator.getAvgRequestTime(count, jsonPlaceholderServiceUrl);
  }

  @GetMapping("/get-avg-time/auth-service")
  public Double performRequestToAuthService(@RequestParam Long count) {
    return averageResponseTimeCalculator.getAvgRequestTime(count, authServiceUrl);
  }

}
