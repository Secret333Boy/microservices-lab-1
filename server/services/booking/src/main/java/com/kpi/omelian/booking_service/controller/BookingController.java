package com.kpi.omelian.booking_service.controller;

import com.kpi.omelian.booking_service.aspect.SecuredEndpoint;
import com.kpi.omelian.booking_service.entity.Ticket;
import com.kpi.omelian.booking_service.entity.dto.TicketDto;
import com.kpi.omelian.booking_service.service.IBookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/booking/book")
public class BookingController {
    // TODO integration with user ---> done
    // TODO send email
    private final IBookingService bookingService;
    private final ModelMapper modelMapper;

    @Autowired
    public BookingController(IBookingService bookingService, ModelMapper modelMapper) {
        this.bookingService = bookingService;
        this.modelMapper = modelMapper;
    }

    @SecuredEndpoint
    @GetMapping
    public List<TicketDto> getAll() {
        return this.bookingService.getAllTickets().stream()
                .map(ticket -> modelMapper.map(ticket, TicketDto.class))
                .collect(Collectors.toList());
    }

    @SecuredEndpoint
    @PostMapping
    public Ticket book(@Valid @RequestBody TicketDto ticketDto) {
        return this.bookingService.bookSeat(ticketDto);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@Valid @RequestBody Long ticketId) {
        this.bookingService.removeBooking(ticketId);
    }

}
