package com.kpi.moviemanagementservice.repositories.demo;

import com.kpi.moviemanagementservice.models.Movie;
import com.kpi.moviemanagementservice.models.MovieFeedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DemoMovieFeedbackRepository {

    private List<MovieFeedback> movieFeedbacks;

    public DemoMovieFeedbackRepository(DemoMovieRepository demoMovieRepository) {
        this.movieFeedbacks = new ArrayList<>();
        Random random = new Random();
        for (Movie movie : demoMovieRepository.getMovies()) {
            for (int i = 0; i < 5; i++) {
                this.movieFeedbacks.add(MovieFeedback.builder()
                        .movie(movie)
                        .score(random.nextInt() % 10 + 1)
                        .comment(String.format("Feedback %d for movie %d", i + 1, movie.getId()))
                        .userId(random.nextLong() % 5 + 1)
                        .build());
            }
        }

    }

    public List<MovieFeedback> getMovieFeedbacks() {
        return movieFeedbacks;
    }
}
