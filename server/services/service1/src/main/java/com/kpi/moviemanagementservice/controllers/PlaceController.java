package com.kpi.moviemanagementservice.controllers;

import com.kpi.moviemanagementservice.models.Place;
import com.kpi.moviemanagementservice.services.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/places")
@AllArgsConstructor
public class PlaceController {

    private PlaceService placeService;

    @GetMapping
    public List<Place> getAllPlacesOfHall(@RequestParam(value = "hall_id", required = false) Long hallId) {
        if (hallId == null) {
            return placeService.getAllPlaces();
        }
        return placeService.getAllPlacesOfHall(hallId);
    }
}
