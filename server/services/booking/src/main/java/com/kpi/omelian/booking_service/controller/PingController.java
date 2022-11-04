package com.kpi.omelian.booking_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking/ping")
public class PingController {

    @GetMapping({"/", ""})
    public String getPong(){
        return "pong";
    }
}
