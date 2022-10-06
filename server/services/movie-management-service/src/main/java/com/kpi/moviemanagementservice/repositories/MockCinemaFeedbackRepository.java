package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Cinema;
import com.kpi.moviemanagementservice.models.CinemaFeedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MockCinemaFeedbackRepository {
    private List<CinemaFeedback> cinemaFeedbacks;

    public MockCinemaFeedbackRepository(MockCinemaRepository mockCinemaRepository) {
        this.cinemaFeedbacks = new ArrayList<>();
        Random random = new Random();
        long movieFeedbackId = 1;
        for (Cinema cinema : mockCinemaRepository.getCinemas()) {
            for (int i = 0; i < 5; i++) {
                this.cinemaFeedbacks.add(CinemaFeedback.builder()
                        .id(movieFeedbackId++)
                        .cinema(cinema)
                        .score(random.nextInt(1, 11))
                        .comment(String.format("Feedback %d for cinema %d", i + 1, cinema.getId()))
                        .userId(random.nextLong(1, 6))
                        .build());
            }
        }

    }

    public List<CinemaFeedback> getCinemaFeedbacks() {
        return cinemaFeedbacks;
    }
}
