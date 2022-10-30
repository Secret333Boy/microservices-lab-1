package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.CinemaFeedback;
import com.kpi.moviemanagementservice.repositories.CinemaFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CinemaFeedbackService {

    private final CinemaFeedbackRepository cinemaFeedbackRepository;

    public List<CinemaFeedback> getAllCinemaFeedbacks(Long cinemaId) {
        return cinemaFeedbackRepository.findAll().stream().filter(movieFeedback -> movieFeedback.getCinema().getId().equals(cinemaId)).collect(Collectors.toList());
    }
}
