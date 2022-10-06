package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Hall;
import com.kpi.moviemanagementservice.repositories.MockHallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HallService {
    private MockHallRepository mockHallRepository;

    public List<Hall> getAllHalls() {
        return mockHallRepository.getHalls();
    }

    public List<Hall> getAllHallsOfCinema(Long cinemaId) {
        return mockHallRepository.getHalls().stream().filter(hall -> hall.getCinema().getId().equals(cinemaId)).collect(Collectors.toList());
    }
}
