package com.kpi.omelian.booking_service.repository;

import com.kpi.omelian.booking_service.entity.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Long> {
}
