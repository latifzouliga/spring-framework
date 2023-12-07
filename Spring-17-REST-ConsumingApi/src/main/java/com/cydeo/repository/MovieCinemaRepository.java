package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id

    @Override
    Optional<MovieCinema> findById(Long id);


    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countByMovieId(Long id);


    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findByDateTimeAfter(LocalDateTime date);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3ByOrderByMovie_PriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovie_NameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findByCinema_Location_Name(String location);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date

    @Query("SELECT m FROM MovieCinema m WHERE m.dateTime > ?1")
    List<MovieCinema> getAllMovieCinemaHigherThan(LocalDateTime date);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
//    @Query("SELECT count(m) FROM MovieCinema m WHERE m.id = ?1")
//    Integer countAllById(Long id);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "select * FROM movie_cinema mc " +
            "join cinema c on mc.cinema_id = c.id " +
            "join location l on c.location_id = l.id " +
            "where l.name = ?1",nativeQuery = true)
    List<MovieCinema> getAllMovieCinemaByLocation(String locationName);
//

}
