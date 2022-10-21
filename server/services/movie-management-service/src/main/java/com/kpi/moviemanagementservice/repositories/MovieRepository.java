package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
