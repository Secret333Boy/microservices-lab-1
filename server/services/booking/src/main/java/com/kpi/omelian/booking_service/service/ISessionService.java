package com.kpi.omelian.booking_service.service;

import com.kpi.omelian.booking_service.entity.dto.SessionDto;
import com.kpi.omelian.booking_service.entity.Session;
import com.kpi.omelian.booking_service.exception.NonExistedSessionError;

public interface ISessionService {

    Session save(SessionDto sessionDto);

    void delete(Long sessionId) throws NonExistedSessionError;

}
