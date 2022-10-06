package com.kpi.omelian.booking_service.repository;

import com.kpi.omelian.booking_service.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
