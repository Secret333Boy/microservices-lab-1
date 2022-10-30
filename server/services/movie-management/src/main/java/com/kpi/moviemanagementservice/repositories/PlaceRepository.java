package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
