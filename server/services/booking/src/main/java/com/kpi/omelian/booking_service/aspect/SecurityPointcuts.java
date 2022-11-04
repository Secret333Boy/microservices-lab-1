package com.kpi.omelian.booking_service.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class SecurityPointcuts {

    @Pointcut("@annotation(com.kpi.omelian.booking_service.aspect.SecuredEndpoint)")
    public void allSecuredMethods(){}

}
