package com.kpi.omelian.booking_service.service;

import com.kpi.omelian.booking_service.dto.TicketDto;
import com.kpi.omelian.booking_service.entity.Ticket;
import com.kpi.omelian.booking_service.exception.NonExistedSessionError;
import com.kpi.omelian.booking_service.exception.NonExistedTicketError;
import com.kpi.omelian.booking_service.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private TicketRepository ticketRepository;
    private ModelMapper modelMapper;

    @Override
    public List<Ticket> getAllTickets() {
        return this.ticketRepository.findAll();
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
