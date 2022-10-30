package com.kpi.omelian.booking_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(value = 0, message = "Minimal price for ticket is 0")
    private Double price;

    @Min(value = 1, message = "User id can't be less than 1.")
    private Long userId;

    @Min(value = 1, message = "Session id can't be less than 1.")
    private Long sessionId;

    @Min(value = 1, message = "Place id can't be less than 1.")
    private Long placeId;

}
