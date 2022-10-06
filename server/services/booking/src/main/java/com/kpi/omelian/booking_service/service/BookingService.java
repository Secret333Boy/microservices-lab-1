package com.kpi.omelian.booking_service.service;

import com.kpi.omelian.booking_service.dto.TicketDto;
import com.kpi.omelian.booking_service.entity.Ticket;
import com.kpi.omelian.booking_service.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class BookingService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket bookSeat(TicketDto ticketDto) {
        return new Ticket();
    }

}
