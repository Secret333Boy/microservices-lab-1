package com.kpi.omelian.booking_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {

    // To set GenerationType.IDENTITY please check https://stackoverflow.com/questions/50659505/spring-boot-project-fails-to-run-because-of-schema-validation-missing-sequence
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "Minimal price for ticket is 0")
    private BigDecimal price;

    @Min(value = 1, message = "User id can't be less than 1.")
    private Long userId;

    @Min(value = 1, message = "Session id can't be less than 1.")
    private Long sessionId;

    @Min(value = 1, message = "Place id can't be less than 1.")
    private Long placeId;

}
