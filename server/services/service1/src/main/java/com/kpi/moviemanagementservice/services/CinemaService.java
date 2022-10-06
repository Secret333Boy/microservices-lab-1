package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Cinema;
import com.kpi.moviemanagementservice.repositories.MockCinemaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CinemaService {

    private MockCinemaRepository mockCinemaRepository;

    public List<Cinema> getAllCinemas() {
        return mockCinemaRepository.getCinemas();
    }
}
