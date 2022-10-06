package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Movie;
import com.kpi.moviemanagementservice.models.MovieFeedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MockMovieFeedbackRepository {

    private List<MovieFeedback> movieFeedbacks;

    public MockMovieFeedbackRepository(MockMovieRepository mockMovieRepository) {
        this.movieFeedbacks = new ArrayList<>();
        Random random = new Random();
        long movieFeedbackId = 1;
        for (Movie movie : mockMovieRepository.getMovies()) {
            for (int i = 0; i < 5; i++) {
                this.movieFeedbacks.add(MovieFeedback.builder()
                        .id(movieFeedbackId++)
                        .movie(movie)
                        .score(random.nextInt(1, 11))
                        .comment(String.format("Feedback %d for movie %d", i + 1, movie.getId()))
                        .userId(random.nextLong(1, 6))
                        .build());
            }
        }

    }

    public List<MovieFeedback> getMovieFeedbacks() {
        return movieFeedbacks;
    }
}
