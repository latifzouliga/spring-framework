package com.cydeo.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@NoArgsConstructor
public class Genre extends BaseEntity{
    private String name;
    @ManyToMany(mappedBy = "genreList") // giving ownership to movie
    private List<Movie> movieList;
}
