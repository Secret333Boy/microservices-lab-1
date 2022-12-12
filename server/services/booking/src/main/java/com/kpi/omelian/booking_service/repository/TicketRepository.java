package com.kpi.omelian.booking_service.repository;

import com.kpi.omelian.booking_service.entity.Session;
import com.kpi.omelian.booking_service.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByUserId(Long userId);

    List<Ticket> findBySessionId(Long sessionId);

    List<Ticket> findByPlaceId(Long placeId);

    boolean existsByPlaceIdEqualsAndSession(Long placeId, Session session);

}
