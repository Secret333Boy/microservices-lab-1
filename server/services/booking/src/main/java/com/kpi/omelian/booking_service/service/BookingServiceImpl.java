package com.kpi.omelian.booking_service.service;

import com.kpi.omelian.booking_service.dto.TicketDto;
import com.kpi.omelian.booking_service.entity.Ticket;
import com.kpi.omelian.booking_service.exception.NonExistedTicketError;
import com.kpi.omelian.booking_service.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private TicketRepository ticketRepository;
    private ModelMapper modelMapper;

    @Override
    public List<Ticket> getAllTickets() {
        return this.ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getAllTicketsByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Ticket> getAllTicketsBySessionId(Long sessionId) {
        return null;
    }

    @Override
    public List<Ticket> getAllTicketsByPlaceId(Long placeId) {
        return null;
    }

    @Override
    public Ticket bookSeat(TicketDto ticketDto) {
        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        // return this.ticketRepository.save(ticket);
        return new Ticket(
                1L,
                20.0,
                1L,
                2L,
                3L
        );
    }

    @Override
    public void removeBooking(Long bookingId) throws NonExistedTicketError {
        Ticket ticket = ticketRepository.findById(bookingId).orElse(null);
        if (ticket == null) {
            throw new NonExistedTicketError(NonExistedTicketError.ERROR_MESSAGE);
        }
        ticketRepository.delete(ticket);
    }

}
