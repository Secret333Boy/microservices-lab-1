package com.kpi.zaranik.third_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/api/email/ping")
    public String getResponse(){
        return "Hello from service 3";
    }

}
