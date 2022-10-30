package com.kpi.moviemanagementservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie-management")
public class PingController {

    @GetMapping("/ping")
    public String getResponse() {
        return "Hello from the movie management service";
    }

}
