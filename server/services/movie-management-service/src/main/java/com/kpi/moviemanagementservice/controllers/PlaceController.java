package com.kpi.moviemanagementservice.controllers;

import com.kpi.moviemanagementservice.models.Place;
import com.kpi.moviemanagementservice.services.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/places")
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
}
