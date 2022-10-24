package com.kpi.omelian.booking_service.controller;

import com.kpi.omelian.booking_service.dto.TicketDto;
import com.kpi.omelian.booking_service.entity.Ticket;
import com.kpi.omelian.booking_service.exception.NonExistedTicketError;
import com.kpi.omelian.booking_service.service.IBookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookingController {

    private final IBookingService bookingService;
    private final ModelMapper modelMapper;

    @Autowired
    public BookingController(IBookingService bookingService, ModelMapper modelMapper) {
        this.bookingService = bookingService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<TicketDto> getAll() {
        return this.bookingService.getAllTickets().stream()
                .map(ticket -> modelMapper.map(ticket, TicketDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Ticket> book(@Valid @RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(this.bookingService.bookSeat(ticketDto));
    }

    @DeleteMapping
    public ResponseEntity<TicketDto> remove(@Valid @RequestBody Long ticketId) {
        try {
            this.bookingService.removeBooking(ticketId);
            return ResponseEntity.noContent().build();
        } catch (NonExistedTicketError e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
