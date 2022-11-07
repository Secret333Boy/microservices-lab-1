package com.kpi.omelian.booking_service.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Aspect
@Component
@Slf4j
public class SecurityAspect {

    @Value("${auth-service.url}")
    private String authServiceUrl;

    private final HttpServletRequest request;

    private final HttpServletResponse response;

    private final ObjectMapper objectMapper;

    @Autowired
    public SecurityAspect(
            HttpServletRequest request,
            HttpServletResponse response,
            ObjectMapper objectMapper
    ) {
        this.request = request;
        this.response = response;
        this.objectMapper = objectMapper;
    }

    @Around("com.kpi.omelian.booking_service.aspect.SecurityPointcuts.allSecuredMethods()")
    public void allSecuredMethodsAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        response.setContentType("application/json");

        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, authorizationHeader);
        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);

        try {
            restTemplate.exchange(
                    authServiceUrl,
                    HttpMethod.GET,
                    httpEntity,
                    String.class
            );
        }catch(Exception e){
            sendUnauthorized("Unauthorized user are not allowed to permit this operation.");
            log.error("Authorized from another account, can't perform this request.");
            return;
        }

        Object proceed = joinPoint.proceed();

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.print(objectMapper.writeValueAsString(proceed));
        outputStream.flush();
    }

    private void sendUnauthorized(String body) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.print(body);
        outputStream.flush();
    }

}
