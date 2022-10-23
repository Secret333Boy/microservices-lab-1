package com.kpi.moviemanagementservice.controllers;

import com.kpi.moviemanagementservice.models.Hall;
import com.kpi.moviemanagementservice.services.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/halls")
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

    @PostMapping
    public Hall createHall(@RequestBody Hall hall) {
        return hallService.createHall(hall);
    }

    @PutMapping
    public Hall updateHall(@RequestBody Hall hall) {
        return hallService.updateHall(hall);
    }

    @DeleteMapping("/{id}")
    public void deleteHall(@PathVariable Long id) {
        hallService.deleteHall(id);
    }
}
