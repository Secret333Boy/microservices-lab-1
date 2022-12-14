package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import lombok.SneakyThrows;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.RestTemplate;

@Service
public class AverageResponseTimeCalculator {

  @SneakyThrows
  public double getAvgRequestTime(Long count, String url) {
    long summaryTime = 0;

    Map<CompletableFuture<?>, Long> map = new HashMap<>();
    for (int i = 0; i < count; i++) {
      map.put(getResponse(url), System.currentTimeMillis());
    }

    for (var response : map.keySet()) {
      Long timeStarted = map.get(response);
      response.get();
      long timeFinished = System.currentTimeMillis();
      summaryTime += timeFinished - timeStarted;
    }
    return summaryTime / 1000.0 / count;
  }


  private CompletableFuture<?> getResponse(String url) {
    RestTemplate rest = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("content-type", "application/json");

    HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
    return CompletableFuture.supplyAsync(() -> rest.exchange(url, HttpMethod.GET, requestEntity, String.class))
      .exceptionally(e -> {
        ResponseEntity<String> result = null;
        if (e instanceof NotFound nfe) {
          HttpStatus statusCode = nfe.getStatusCode();
          System.out.println("NOT_FOUND");
          result = ResponseEntity.status(statusCode).body("not found");
        } else if (e instanceof Unauthorized unauthorized) {
          HttpStatus statusCode = unauthorized.getStatusCode();
          System.out.println("UNAUTHORIZED");
          result = ResponseEntity.status(statusCode).body("unauthorized");
        }
        return result;
      });
  }

}
