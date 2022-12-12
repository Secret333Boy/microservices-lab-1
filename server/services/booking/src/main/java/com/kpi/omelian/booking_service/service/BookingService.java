package com.kpi.omelian.booking_service.service;

import com.kpi.omelian.booking_service.entity.Session;
import com.kpi.omelian.booking_service.entity.Ticket;
import com.kpi.omelian.booking_service.entity.dto.TicketDto;
import com.kpi.omelian.booking_service.exception.BookingSeatNotValidException;
import com.kpi.omelian.booking_service.exception.NonExistedTicketError;
import com.kpi.omelian.booking_service.repository.SessionRepository;
import com.kpi.omelian.booking_service.repository.TicketRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService {

    private final TicketRepository ticketRepository;
    private final SessionRepository sessionRepository;
    private final MovieManagementRequestPerformerService requestPerformerService;
    private final ModelMapper modelMapper;

    @Override
    public List<Ticket> getAllTickets() {
        return this.ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getAllTicketsByUserId(Long userId) {
        return this.ticketRepository.findByUserId(userId);
    }

    @Override
    public List<Ticket> getAllTicketsBySessionId(Long sessionId) {
        return this.ticketRepository.findBySessionId(sessionId);
    }

    @Override
    public List<Ticket> getAllTicketsByPlaceId(Long placeId) {
        return this.ticketRepository.findByPlaceId(placeId);
    }

    @Override
    public Ticket bookSeat(TicketDto ticketDto) {
        Optional<Session> sessionOptional = sessionRepository.findById(ticketDto.getSessionId());
        if(sessionOptional.isEmpty()){
            throw new BookingSeatNotValidException();
        }
        Long placeId = ticketDto.getPlaceId();
        Session session = sessionOptional.get();
        if(ticketRepository.existsByPlaceIdEqualsAndSession(placeId, session)){
            throw new BookingSeatNotValidException();
        }
        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        ticket.setSession(session);
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
