package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Place;
import com.kpi.moviemanagementservice.repositories.MockPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final MockPlaceRepository mockPlaceRepository;

    public List<Place> getAllPlaces() {
        return mockPlaceRepository.getPlaces();
    }

    public List<Place> getAllPlacesOfHall(Long hallId) {
        return mockPlaceRepository.getPlaces().stream().filter(place -> place.getHall().getId().equals(hallId)).collect(Collectors.toList());
    }

    public Place getPlaceById(Long id) {
        return mockPlaceRepository.getPlaces().stream().filter(place -> place.getId().equals(id)).findFirst().orElseThrow();
    }
}
