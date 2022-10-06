package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Cinema;
import com.kpi.moviemanagementservice.models.Hall;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockHallRepository {
    private List<Hall> halls;

    public MockHallRepository(MockCinemaRepository mockCinemaRepository) {
        this.halls = new ArrayList<>();
        long hallId = 1;
        for (Cinema cinema : mockCinemaRepository.getCinemas()) {
            for (int i = 0; i < 3; i++) {
                halls.add(Hall.builder()
                        .id(hallId++)
                        .name("Hall " + (i + 1))
                        .cinema(cinema)
                        .build());
            }
        }
    }

    public List<Hall> getHalls() {
        return halls;
    }
}
