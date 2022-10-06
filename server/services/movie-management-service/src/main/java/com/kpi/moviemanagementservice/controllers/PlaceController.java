package com.kpi.moviemanagementservice.controllers;

import com.kpi.moviemanagementservice.models.Place;
import com.kpi.moviemanagementservice.services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/{id}")
    public Place getPlace(@PathVariable Long id) {
        return placeService.getPlaceById(id);
    }

    @GetMapping
    public List<Place> getAllPlacesOfHall(@RequestParam(value = "hall_id", required = false) Long hallId) {
        if (hallId == null) {
            return placeService.getAllPlaces();
        }
        return placeService.getAllPlacesOfHall(hallId);
    }

    @PostMapping
    public Place createPlace(@RequestBody Place place) {
        return placeService.createPlace(place);
    }

    @PutMapping
    public Place updatePlace(@RequestBody Place place) {
        return placeService.updatePlace(place);
    }

    @DeleteMapping("{id}")
    public Place deletePlace(@PathVariable Long id) {
        return placeService.deletePlace(id);
    }
}
