package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.CinemaFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaFeedbackRepository extends JpaRepository<CinemaFeedback, Long> {
}
