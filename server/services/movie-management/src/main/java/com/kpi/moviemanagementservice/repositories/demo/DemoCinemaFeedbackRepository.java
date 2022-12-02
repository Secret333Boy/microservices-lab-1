package com.kpi.moviemanagementservice.repositories.demo;

import com.kpi.moviemanagementservice.models.Cinema;
import com.kpi.moviemanagementservice.models.CinemaFeedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DemoCinemaFeedbackRepository {
    private List<CinemaFeedback> cinemaFeedbacks;

    public DemoCinemaFeedbackRepository(DemoCinemaRepository demoCinemaRepository) {
        this.cinemaFeedbacks = new ArrayList<>();
        Random random = new Random();
        for (Cinema cinema : demoCinemaRepository.getCinemas()) {
            for (int i = 0; i < 5; i++) {
                this.cinemaFeedbacks.add(CinemaFeedback.builder()
                        .cinema(cinema)
                        .score(random.nextInt() % 10 + 1)
                        .comment(String.format("Feedback %d for cinema %d", i + 1, cinema.getId()))
                        .userId(random.nextLong() % 5 + 1)
                        .build());
            }
        }

    }

    public List<CinemaFeedback> getCinemaFeedbacks() {
        return cinemaFeedbacks;
    }
}
