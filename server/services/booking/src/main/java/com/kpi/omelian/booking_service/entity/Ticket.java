package com.kpi.omelian.booking_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    private Long id;

    private Double price;

    private Long userId;

    private Long sessionId;

    private Long placeId;

}
