package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Long> {
}
