package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
