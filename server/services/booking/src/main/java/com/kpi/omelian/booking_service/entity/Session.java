package com.kpi.omelian.booking_service.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "Movie id can't be less than 1.")
    private Long movieId;

    @Min(value = 1, message = "Hall id can't be less than 1.")
    private Long hallId;

    @Min(value = 1, message = "Cinema id can't be less than 1.")
    private Long cinemaId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

}
