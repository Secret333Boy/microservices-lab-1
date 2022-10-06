package com.kpi.moviemanagementservice.controllers;

import com.kpi.moviemanagementservice.models.Hall;
import com.kpi.moviemanagementservice.services.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/halls")
@RequiredArgsConstructor
public class HallController {

    private final HallService hallService;

    @GetMapping("/{id}")
    public Hall getHall(@PathVariable Long id) {
        return hallService.getHallById(id);
    }

    @GetMapping
    public List<Hall> getAllHallsOfCinema(@RequestParam(value = "cinema_id", required = false) Long cinemaId) {
        if (cinemaId == null) {
            return hallService.getAllHalls();
        }
        return hallService.getAllHallsOfCinema(cinemaId);
    }
}
