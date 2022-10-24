package com.kpi.omelian.booking_service.service;

import com.kpi.omelian.booking_service.entity.dto.TicketDto;
import com.kpi.omelian.booking_service.entity.Ticket;
import com.kpi.omelian.booking_service.exception.NonExistedTicketError;

import java.util.List;

public interface IBookingService {

    List<Ticket> getAllTickets();

    List<Ticket> getAllTicketsByUserId(Long userId);

    List<Ticket> getAllTicketsBySessionId(Long sessionId);

    List<Ticket> getAllTicketsByPlaceId(Long placeId);

    Ticket bookSeat(TicketDto ticketDto);

    void removeBooking(Long bookingId) throws NonExistedTicketError;

}
