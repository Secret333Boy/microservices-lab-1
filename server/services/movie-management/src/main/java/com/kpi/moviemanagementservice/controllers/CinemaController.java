package com.kpi.moviemanagementservice.controllers;

import com.kpi.moviemanagementservice.models.Cinema;
import com.kpi.moviemanagementservice.models.CinemaFeedback;
import com.kpi.moviemanagementservice.models.Hall;
import com.kpi.moviemanagementservice.models.Place;
import com.kpi.moviemanagementservice.services.CinemaFeedbackService;
import com.kpi.moviemanagementservice.services.CinemaService;
import com.kpi.moviemanagementservice.services.HallService;
import com.kpi.moviemanagementservice.services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;
    private final CinemaFeedbackService cinemaFeedbackService;
    private final HallService hallService;
    private final PlaceService placeService;

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
    public void deleteCinema(@PathVariable Long id) {
        cinemaService.deleteCinema(id);
    }

    @GetMapping("/{cinema_id}/halls")
    public List<Hall> getAllHallsOfCinema(@PathVariable("cinema_id") Long cinemaId) {
        return hallService.getAllHallsOfCinema(cinemaId);
    }

    @GetMapping("/{cinema_id}/halls/{id}")
    public Hall getHall(@PathVariable Long id) {
        return hallService.getHallById(id);
    }

    @PostMapping("/{cinema_id}/halls")
    public Hall createHall(@PathVariable("cinema_id") Long cinemaId, @RequestBody Hall hall) {
        Cinema cinema = cinemaService.getCinemaById(cinemaId);
        hall.setCinema(cinema);
        return hallService.createHall(hall);
    }

    @PutMapping("/{cinema_id}/halls/{id}")
    public Hall updateHall(@RequestBody Hall hall) {
        return hallService.updateHall(hall);
    }

    @DeleteMapping("/{cinema_id}/halls/{id}")
    public void deleteHall(@PathVariable Long id) {
        hallService.deleteHall(id);
    }


    @GetMapping("/{cinema_id}/halls/{hall_id}/places/{id}")
    public Place getPlace(@PathVariable Long id) {
        return placeService.getPlaceById(id);
    }

    @GetMapping("/{cinema_id}/halls/{hall_id}/places")
    public List<Place> getAllPlacesOfHall(@PathVariable("hall_id") Long hallId) {
        if (hallId == null) {
            return placeService.getAllPlaces();
        }
        return placeService.getAllPlacesOfHall(hallId);
    }

    @PostMapping("/{cinema_id}/halls/{hall_id}/places")
    public Place createPlace(@RequestBody Place place) {
        return placeService.createPlace(place);
    }

    @PutMapping("/{cinema_id}/halls/{hall_id}/places")
    public Place updatePlace(@RequestBody Place place) {
        return placeService.updatePlace(place);
    }

    @DeleteMapping("/{cinema_id}/halls/{hall_id}/places/{id}")
    public void deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
    }

}
