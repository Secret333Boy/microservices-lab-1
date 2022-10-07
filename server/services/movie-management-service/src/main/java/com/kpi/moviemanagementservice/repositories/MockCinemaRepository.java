package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Cinema;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockCinemaRepository {
    private Long id = 1L;
    private List<Cinema> cinemas;

    public MockCinemaRepository() {
        this.cinemas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cinemas.add(Cinema.builder()
                    .id(id++)
                    .name("Cinema " + (i + 1))
                    .location("Location of the cinema " + (i + 1))
                    .build());
        }
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    public Cinema updateCinema(Cinema cinema) {
        for (int i = 0; i < cinemas.size(); i++) {
            if (cinemas.get(i).getId().equals(cinema.getId())) {
                cinemas.set(i, cinema);
                return cinema;
            }
        }
        return null;
    }

    public Cinema createCinema(Cinema cinema) {
        cinema.setId(id++);
        cinemas.add(cinema);
        return cinema;
    }

    public Cinema deleteCinema(Long id) {
        for (int i = 0; i < cinemas.size(); i++) {
            if (cinemas.get(i).getId().equals(id)) {
                return cinemas.remove(i);
            }
        }
        return null;
    }
}
