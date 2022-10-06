package com.kpi.omelian.booking_service.controller;

import com.kpi.omelian.booking_service.dto.TicketDto;
import com.kpi.omelian.booking_service.entity.Ticket;
import com.kpi.omelian.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Ticket> book(@Valid @RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(bookingService.bookSeat(ticketDto));
    }



}
