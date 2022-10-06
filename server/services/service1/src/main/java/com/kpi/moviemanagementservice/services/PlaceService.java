package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Place;
import com.kpi.moviemanagementservice.repositories.MockPlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlaceService {

    private MockPlaceRepository mockPlaceRepository;

    public List<Place> getAllPlaces() {
        return mockPlaceRepository.getPlaces();
    }

    public List<Place> getAllPlacesOfHall(Long hallId) {
        return mockPlaceRepository.getPlaces().stream().filter(place -> place.getHall().getId().equals(hallId)).collect(Collectors.toList());
    }
}
