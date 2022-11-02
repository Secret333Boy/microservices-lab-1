package com.kpi.omelian.booking_service.service;

import com.kpi.omelian.booking_service.entity.Ticket;
import com.kpi.omelian.booking_service.entity.dto.TicketDto;
import com.kpi.omelian.booking_service.exception.NonExistedTicketError;
import com.kpi.omelian.booking_service.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService {

    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Ticket> getAllTickets() {
        Ticket ticket = new Ticket(1L, new BigDecimal(10.0), 10L, 1L, 1L);
        return List.of(ticket);
    }

    @Override
    public List<Ticket> getAllTicketsByUserId(Long userId) {
        return this.ticketRepository.findByUserId(userId).orElse(null);
    }

    @Override
    public List<Ticket> getAllTicketsBySessionId(Long sessionId) {
        return this.ticketRepository.findBySessionId(sessionId).orElse(null);
    }

    @Override
    public List<Ticket> getAllTicketsByPlaceId(Long placeId) {
        return this.ticketRepository.findByPlaceId(placeId).orElse(null);
    }

    @Override
    public Ticket bookSeat(TicketDto ticketDto) {
        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        return this.ticketRepository.save(ticket);
    }

    @Override
    public void removeBooking(Long bookingId) throws NonExistedTicketError {
        if (!this.ticketRepository.existsById(bookingId)) {
            throw new NonExistedTicketError(NonExistedTicketError.ERROR_MESSAGE);
        }
        this.ticketRepository.deleteById(bookingId);
    }

}
