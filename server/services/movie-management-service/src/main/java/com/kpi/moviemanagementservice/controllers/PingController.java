package com.kpi.moviemanagementservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/api/movie-management/ping")
    public String getResponse() {
        return "Hello from the movie management service";
    }

}
