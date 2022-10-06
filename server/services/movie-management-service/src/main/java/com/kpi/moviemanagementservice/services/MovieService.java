package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Movie;
import com.kpi.moviemanagementservice.repositories.MockMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MockMovieRepository mockMovieRepository;

    public List<Movie> getAllMovies() {
        return mockMovieRepository.getMovies();
    }

    public Movie getMovieById(Long id) {
        return mockMovieRepository.getMovies().stream().filter(movie -> movie.getId().equals(id)).findFirst().orElseThrow();
    }
}
