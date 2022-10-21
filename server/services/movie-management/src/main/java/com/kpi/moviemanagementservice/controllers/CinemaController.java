package com.kpi.moviemanagementservice.controllers;

import com.kpi.moviemanagementservice.models.Cinema;
import com.kpi.moviemanagementservice.models.CinemaFeedback;
import com.kpi.moviemanagementservice.services.CinemaFeedbackService;
import com.kpi.moviemanagementservice.services.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;
    private final CinemaFeedbackService cinemaFeedbackService;

    @GetMapping
    public List<Cinema> getAll() {
        return cinemaService.getAllCinemas();
    }

    @GetMapping("/{id}")
    public Cinema getCinema(@PathVariable Long id) {
        return cinemaService.getCinemaById(id);
    }

    @GetMapping("/{movie_id}/feedbacks")
    public List<CinemaFeedback> getAllCinemaFeedbacks(@PathVariable("movie_id") Long movieId) {
        return cinemaFeedbackService.getAllCinemaFeedbacks(movieId);
    }

    @PostMapping
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaService.createCinema(cinema);
    }

    @PutMapping
    public Cinema updateCinema(@RequestBody Cinema cinema) {
        return cinemaService.updateCinema(cinema);
    }

    @DeleteMapping("/{id}")
    public Cinema deleteCinema(@PathVariable Long id) {
        return cinemaService.deleteCinema(id);
    }
}
