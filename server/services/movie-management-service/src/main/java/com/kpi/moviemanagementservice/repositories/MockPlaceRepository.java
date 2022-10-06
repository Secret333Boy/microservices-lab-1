package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Hall;
import com.kpi.moviemanagementservice.models.Place;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockPlaceRepository {
    private List<Place> places;

    public MockPlaceRepository(MockHallRepository mockHallRepository) {
        this.places = new ArrayList<>();
        long placeId = 1;
        for (Hall hall : mockHallRepository.getHalls()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    places.add(Place.builder()
                            .id(placeId++)
                            .hall(hall)
                            .row((long) (i + 1))
                            .placeNumber((long) (j + 1))
                            .build());
                }
            }
        }
    }

    public List<Place> getPlaces() {
        return places;
    }
}
