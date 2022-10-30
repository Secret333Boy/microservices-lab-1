package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Place;
import com.kpi.moviemanagementservice.repositories.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public List<Place> getAllPlacesOfHall(Long hallId) {
        return placeRepository.findAll().stream().filter(place -> place.getHall().getId().equals(hallId)).collect(Collectors.toList());
    }

    public Place getPlaceById(Long id) {
        return placeRepository.findAll().stream().filter(place -> place.getId().equals(id)).findFirst().orElseThrow();
    }

    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    public Place updatePlace(Place place) {
        return placeRepository.save(place);
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }
}
