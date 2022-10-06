package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.CinemaFeedback;
import com.kpi.moviemanagementservice.repositories.MockCinemaFeedbackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CinemaFeedbackService {

    private MockCinemaFeedbackRepository mockCinemaFeedbackRepository;

    public List<CinemaFeedback> getAllCinemaFeedbacks(Long cinemaId) {
        return mockCinemaFeedbackRepository.getCinemaFeedbacks().stream().filter(movieFeedback -> movieFeedback.getCinema().getId().equals(cinemaId)).collect(Collectors.toList());
    }
}
