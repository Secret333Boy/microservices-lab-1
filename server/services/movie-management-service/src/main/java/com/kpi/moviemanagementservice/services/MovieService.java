package com.kpi.moviemanagementservice.services;

import com.kpi.moviemanagementservice.models.Movie;
import com.kpi.moviemanagementservice.repositories.MockMovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private MockMovieRepository mockMovieRepository;

    public List<Movie> getAllMovies() {
        return mockMovieRepository.getMovies();
    }
}
