package com.kpi.omelian.booking_service.controller;

import com.kpi.omelian.booking_service.entity.dto.SessionDto;
import com.kpi.omelian.booking_service.entity.dto.TicketDto;
import com.kpi.omelian.booking_service.entity.Session;
import com.kpi.omelian.booking_service.exception.NonExistedSessionError;
import com.kpi.omelian.booking_service.service.SessionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/booking/session")
public class SessionController {

    private final SessionService sessionService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<TicketDto> getAll() {
        return this.sessionService.findAllSessions().stream()
                .map(session -> this.modelMapper.map(session, TicketDto.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Session> book(@Valid @RequestBody SessionDto sessionDto) {
        return ResponseEntity.ok(this.sessionService.save(sessionDto));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@Valid @RequestBody Long sessionId) {
        this.sessionService.delete(sessionId);
    }

}
