package com.kpi.omelian.booking_service.controller;

import com.kpi.omelian.booking_service.dto.SessionDto;
import com.kpi.omelian.booking_service.dto.TicketDto;
import com.kpi.omelian.booking_service.entity.Session;
import com.kpi.omelian.booking_service.entity.Ticket;
import com.kpi.omelian.booking_service.exception.NonExistedSessionError;
import com.kpi.omelian.booking_service.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/session")
public class SessionController {

    private SessionService sessionService;
    private ModelMapper modelMapper;

    @GetMapping
    public List<TicketDto> getAll() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Session> book(@Valid @RequestBody SessionDto sessionDto) {
        return ResponseEntity.ok(this.sessionService.save(sessionDto));
    }

    @DeleteMapping
    public ResponseEntity<TicketDto> remove(@Valid @RequestBody Long sessionId) {
        try {
            this.sessionService.delete(sessionId);
            return ResponseEntity.noContent().build();
        } catch (NonExistedSessionError e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
