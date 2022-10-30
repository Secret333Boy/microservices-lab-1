package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Hall;
import com.kpi.moviemanagementservice.repositories.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HallService {
    private final HallRepository hallRepository;

    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    public List<Hall> getAllHallsOfCinema(Long cinemaId) {
        return hallRepository.findAll().stream().filter(hall -> hall.getCinema().getId().equals(cinemaId)).collect(Collectors.toList());
    }

    public Hall getHallById(Long id) {
        return hallRepository.findAll().stream().filter(hall -> hall.getId().equals(id)).findFirst().orElseThrow();
    }

    public Hall createHall(Hall hall) {
        return hallRepository.save(hall);
    }

    public Hall updateHall(Hall hall) {
        return hallRepository.save(hall);
    }

    public void deleteHall(Long id) {
        hallRepository.deleteById(id);
    }
}
