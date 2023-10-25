package com.cydeo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Ticket extends BaseEntity {
    @Column(columnDefinition = "timestamp")
    private LocalDateTime dateTime;
    private Integer seatNumber;
    private Integer rowNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private MovieCinema movieCinema;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userAccount;
}
