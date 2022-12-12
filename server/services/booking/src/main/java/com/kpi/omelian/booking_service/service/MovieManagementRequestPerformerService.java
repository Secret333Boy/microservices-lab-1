package com.kpi.omelian.booking_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MovieManagementRequestPerformerService {

  public boolean contentExists(String url) {
    RestTemplate restTemplate = new RestTemplate();
    try {
      restTemplate.getForEntity(url, Object.class);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

}
