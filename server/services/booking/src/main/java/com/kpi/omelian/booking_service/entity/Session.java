package com.kpi.omelian.booking_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(value = 1, message = "Movie id can't be less than 1.")
    private Long movieId;

    @Min(value = 1, message = "Hall id can't be less than 1.")
    private Long hallId;

    private Date startTime;

    private Date endTime;

}
