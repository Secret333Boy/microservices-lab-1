package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Movie;
import com.kpi.moviemanagementservice.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findAll().stream().filter(movie -> movie.getId().equals(id)).findFirst().orElseThrow();
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
