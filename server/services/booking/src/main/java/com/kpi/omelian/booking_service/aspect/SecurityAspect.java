package com.kpi.omelian.booking_service.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class SecurityAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ObjectMapper objectMapper;

    @Pointcut("@annotation(com.kpi.omelian.booking_service.aspect.SecuredEndpoint)")
    private void allSecuredMethods(){}

    @Around("allSecuredMethods()")
    public void allSecuredMethodsAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        response.setContentType("application/json");

        boolean accessAllowed = true;

        /*
         * Put here logic of accessing auth service
         * and set accessAllowed an appropriate value
         * */

        if(accessAllowed) {
            Object proceed = joinPoint.proceed();

            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.print(objectMapper.writeValueAsString(proceed));
            outputStream.flush();
            return;
        }

        /*
        * Process different types of errors connected with access:
        * Forbidden / Unauthorized
        * */
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.print(objectMapper.writeValueAsString("You are not allowed to perform this operation"));
        outputStream.flush();

    }
}
