package com.kpi.omelian.booking_service.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AuthRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("########## Initiating CustomURLFilter filter ##########");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String jwtToken = request.getHeader("Authorization");

        if(jwtToken == null) {
            response.setStatus(401);
            response.getOutputStream().write("API Key is missing!".getBytes());
            log.error("API key is missing to perform this request.");
            return;
        }

        String url = "http://localhost:8081/api/auth/validate";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> authResponse = restTemplate.getForEntity(url, Object.class, 1);

        if (authResponse.getStatusCode() != HttpStatus.OK) {
            response.setStatus(401);
            response.getOutputStream().write("Not authorised!".getBytes());
            log.error("Authorized from another account, can't perform this request.");
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
