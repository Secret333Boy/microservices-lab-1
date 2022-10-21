package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Cinema;
import com.kpi.moviemanagementservice.repositories.MockCinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaService {

    private final MockCinemaRepository mockCinemaRepository;

    public List<Cinema> getAllCinemas() {
        return mockCinemaRepository.getCinemas();
    }

    public Cinema getCinemaById(Long id) {
        return mockCinemaRepository.getCinemas().stream().filter(cinema -> cinema.getId().equals(id)).findFirst().orElseThrow();
    }

    public Cinema updateCinema(Cinema cinema) {
        return mockCinemaRepository.updateCinema(cinema);
    }

    public Cinema createCinema(Cinema cinema) {
        return mockCinemaRepository.createCinema(cinema);
    }

    public Cinema deleteCinema(Long id) {
        return mockCinemaRepository.deleteCinema(id);
    }
}
