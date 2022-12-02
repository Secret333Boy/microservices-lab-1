package com.kpi.moviemanagementservice.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.HEAD;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import com.kpi.moviemanagementservice.models.Movie;
import com.kpi.moviemanagementservice.models.MovieFeedback;
import com.kpi.moviemanagementservice.services.MovieFeedbackService;
import com.kpi.moviemanagementservice.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie-management/movies")
@RequiredArgsConstructor
@CrossOrigin(allowCredentials = "true", methods = {GET, POST, PUT, DELETE, OPTIONS, HEAD, PATCH},
  origins = {"http://localhost:3000", "http://192.168.49.2:80", "http://localhost:80"})
public class MovieController {

    private final MovieService movieService;
    private final MovieFeedbackService movieFeedbackService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/{movie_id}/feedbacks")
    public List<MovieFeedback> getAllMovieFeedbacks(@PathVariable("movie_id") Long movieId) {
        return movieFeedbackService.getAllMovieFeedbacks(movieId);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}
