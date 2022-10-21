package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.MovieFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieFeedbackRepository extends JpaRepository<MovieFeedback, Long> {
}
