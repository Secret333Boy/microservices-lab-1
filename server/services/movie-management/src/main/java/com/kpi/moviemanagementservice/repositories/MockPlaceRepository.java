package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Hall;
import com.kpi.moviemanagementservice.models.Place;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockPlaceRepository {
    private Long id = 1L;
    private List<Place> places;

    public MockPlaceRepository(MockHallRepository mockHallRepository) {
        this.places = new ArrayList<>();
        for (Hall hall : mockHallRepository.getHalls()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    places.add(Place.builder()
                            .id(id++)
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

    public Place createPlace(Place place) {
        place.setId(id++);
        places.add(place);
        return place;
    }

    public Place updatePlace(Place place) {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getId().equals(place.getId())) {
                places.set(i, place);
                return place;
            }
        }
        return null;
    }

    public Place deletePlace(Long id) {
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getId().equals(id)) {
                return places.remove(i);
            }
        }
        return null;
    }
}
