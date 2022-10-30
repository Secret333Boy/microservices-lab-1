package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Cinema;
import com.kpi.moviemanagementservice.repositories.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    public Cinema getCinemaById(Long id) {
        return cinemaRepository.findAll().stream().filter(cinema -> cinema.getId().equals(id)).findFirst().orElseThrow();
    }

    public Cinema updateCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public Cinema createCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public void deleteCinema(Long id) {
        cinemaRepository.deleteById(id);
    }
}
