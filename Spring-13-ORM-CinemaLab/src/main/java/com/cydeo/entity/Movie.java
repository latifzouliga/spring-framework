package com.cydeo.entity;


import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "movieGenreRel",
            joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "genreId")
    )
    private List<Genre> genreList;

}
