package com.kpi.omelian.booking_service.service;

import com.kpi.omelian.booking_service.dto.SessionDto;
import com.kpi.omelian.booking_service.entity.Session;
import com.kpi.omelian.booking_service.exception.NonExistedSessionError;

public interface SessionService {

    Session save(SessionDto sessionDto);

    void delete(Long sessionId) throws NonExistedSessionError;

}
