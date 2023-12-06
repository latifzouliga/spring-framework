package com.cydeo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ticket extends BaseEntity {

    private Integer seatNumber;
    private Integer rowNumber;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne
    private MovieCinema movieCinema;

    @ManyToOne
    private User userAccount;
}