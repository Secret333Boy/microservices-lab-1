package com.kpi.moviemanagementservice.configs;

import com.kpi.moviemanagementservice.repositories.*;
import com.kpi.moviemanagementservice.repositories.demo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitializationConfig {
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final HallRepository hallRepository;
    private final PlaceRepository placeRepository;
    private final CinemaFeedbackRepository cinemaFeedbackRepository;
    private final MovieFeedbackRepository movieFeedbackRepository;

    @Bean
    public CommandLineRunner initDatabase(DemoCinemaRepository cinemaRepository,
                                          DemoMovieRepository movieRepository,
                                          DemoHallRepository hallRepository,
                                          DemoPlaceRepository placeRepository,
                                          DemoCinemaFeedbackRepository cinemaFeedbackRepository,
                                          DemoMovieFeedbackRepository movieFeedbackRepository) {
        return (args) -> {
            if (this.cinemaRepository.count() == 0) {
                this.cinemaRepository.saveAll(cinemaRepository.getCinemas());
            }
            if (this.movieRepository.count() == 0) {
                this.movieRepository.saveAll(movieRepository.getMovies());
            }
            if (this.hallRepository.count() == 0) {
                this.hallRepository.saveAll(hallRepository.getHalls());
            }
            if (this.placeRepository.count() == 0) {
                this.placeRepository.saveAll(placeRepository.getPlaces());
            }
            if (this.cinemaFeedbackRepository.count() == 0) {
                this.cinemaFeedbackRepository.saveAll(cinemaFeedbackRepository.getCinemaFeedbacks());
            }
            if (this.movieFeedbackRepository.count() == 0) {
                this.movieFeedbackRepository.saveAll(movieFeedbackRepository.getMovieFeedbacks());
            }
        };
    }
}
