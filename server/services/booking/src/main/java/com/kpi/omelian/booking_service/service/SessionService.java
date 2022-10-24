package com.kpi.omelian.booking_service.service;

import com.kpi.omelian.booking_service.dto.SessionDto;
import com.kpi.omelian.booking_service.entity.Session;
import com.kpi.omelian.booking_service.exception.NonExistedSessionError;
import com.kpi.omelian.booking_service.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService implements ISessionService {

    private final SessionRepository sessionRepository;
    private final ModelMapper modelMapper;

    @Override
    public Session save(SessionDto sessionDto) {
        Session session = modelMapper.map(sessionDto, Session.class);
        return this.sessionRepository.save(session);
    }

    @Override
    public void delete(Long sessionId) throws NonExistedSessionError {
        if (!this.sessionRepository.existsById(sessionId)) {
            throw new NonExistedSessionError(NonExistedSessionError.ERROR_MESSAGE);
        }
        this.sessionRepository.deleteById(sessionId);
    }

}
