package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MockMovieRepository {
    private List<Movie> movies;

    public MockMovieRepository() {
        this.movies = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            this.movies.add(Movie.builder()
                    .id((long) (i + 1))
                    .name("Movie " + (i + 1))
                    .description("Description of movie " + (i + 1))
                    .duration(random.nextLong(60 * 1000, 24 * 60 * 60 * 1000))
                    .imagePath(String.format("/src/main/resources/images/image%d.jpg", i + 1))
                    .build());
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
