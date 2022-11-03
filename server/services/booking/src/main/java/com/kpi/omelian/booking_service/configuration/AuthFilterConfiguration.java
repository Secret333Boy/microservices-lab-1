package com.kpi.omelian.booking_service.configuration;

import com.kpi.omelian.booking_service.filter.AuthRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthFilterConfiguration {

    @Bean
    public FilterRegistrationBean <AuthRequestFilter> filterRegistrationBean() {
        FilterRegistrationBean <AuthRequestFilter> registrationBean = new FilterRegistrationBean();
        AuthRequestFilter authRequestFilter = new AuthRequestFilter();

        registrationBean.setFilter(authRequestFilter);
        registrationBean.addUrlPatterns("/api/booking/book/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
