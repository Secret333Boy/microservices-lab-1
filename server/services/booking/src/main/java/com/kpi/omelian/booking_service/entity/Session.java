package com.kpi.omelian.booking_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    @Id
    private Long id;

    private Long movieId;

    private Long hallId;

    private Date startTime;

    private Date endTime;

}
