package com.kpi.moviemanagementservice.controllers;

import com.kpi.moviemanagementservice.models.Hall;
import com.kpi.moviemanagementservice.services.HallService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/halls")
@AllArgsConstructor
public class HallController {

    private HallService hallService;

    @GetMapping
    public List<Hall> getAllHallsOfCinema(@RequestParam(value = "cinema_id", required = false) Long cinemaId) {
        if (cinemaId == null) {
            return hallService.getAllHalls();
        }
        return hallService.getAllHallsOfCinema(cinemaId);
    }
}
