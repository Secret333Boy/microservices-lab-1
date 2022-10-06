package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Cinema;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockCinemaRepository {
    private List<Cinema> cinemas;

    public MockCinemaRepository() {
        this.cinemas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cinemas.add(Cinema.builder()
                    .id((long) (i + 1))
                    .name("Cinema " + (i + 1))
                    .location("Location of the cinema " + (i + 1))
                    .build());
        }
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }
}
