package com.kpi.moviemanagementservice.repositories.demo;

import com.kpi.moviemanagementservice.models.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DemoMovieRepository {
    private Long id = 1L;
    private List<Movie> movies;

    public DemoMovieRepository() {
        this.movies = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            this.movies.add(Movie.builder()
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

    public Movie createMovie(Movie movie) {
        movie.setId(id++);
        movies.add(movie);
        return movie;
    }

    public Movie updateMovie(Movie movie) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId().equals(movie.getId())) {
                movies.set(i, movie);
                return movie;
            }
        }
        return null;
    }

    public Movie deleteMovie(Long id) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId().equals(id)) {
                return movies.remove(i);
            }
        }
        return null;
    }
}
