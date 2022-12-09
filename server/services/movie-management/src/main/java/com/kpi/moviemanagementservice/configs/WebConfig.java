package com.kpi.moviemanagementservice.configs;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH", "OPTIONS")
      .allowCredentials(true)
      .allowedOrigins("http://localhost:3000")
      .allowedOrigins("http://localhost:3000/")
      .allowedOrigins("http://192.168.49.2:80")
      .allowedOrigins("http://192.168.49.2:80/")
      .allowedOrigins("http://192.168.49.2")
      .allowedOrigins("http://192.168.49.2/")
      .allowedOrigins("http://localhost")
      .allowedOrigins("http://localhost/")
      .allowedOrigins("http://localhost:80/")
      .allowedOrigins("http://localhost:80");
  }
}
