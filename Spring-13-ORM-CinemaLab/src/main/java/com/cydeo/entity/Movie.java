package com.cydeo.entity;


import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Movie extends BaseEntity{
    private String name;
    @Column(columnDefinition = "date")
    private LocalDate releaseDate;
    private Integer duration;
    private BigDecimal price;
    @Column(columnDefinition = "text")
    private String summary;
    @Enumerated(EnumType.STRING)
    private MovieType type;
    @Enumerated(EnumType.STRING)
    private MovieState state;

}
