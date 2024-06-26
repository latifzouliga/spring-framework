package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> getMovieByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> getAllByPriceBetween(BigDecimal price1, BigDecimal price2);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> getMovieByDurationIn(List<Integer> duration);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> getMovieByReleaseDateAfter(LocalDate dateTime);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> getMovieByStateAndType(MovieState state, MovieType type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m where m.price BETWEEN ?1 AND ?2" )
    List<Movie> getByPriceBetween(BigDecimal price1, BigDecimal price2);

    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name FROM Movie m")
    List<String> fetchAllMovieManes();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "SELECT * From movie WHERE name = ?1",nativeQuery = true)
    Optional<Movie> fitchMovieByName(String name);

    //Write a native query that return the list of movies in a specific range of prices

    @Query(value = "SELECT * FROM movie WHERE price between ?1 and ?2", nativeQuery = true)
    List<Movie> getMoviesBetween(BigDecimal price1, BigDecimal price2);

    //Write a native query to return all movies where duration exists in the range of duration


    @Query(value = "SELECT * FROM movie WHERE duration in ?1",nativeQuery = true)
    List<Movie> getMoviesByDurationIn(Integer... duration);

    //Write a native query to list the top 5 most expensive movies
//    @Query(value = "select * FROM movie ORDER BY price desc LIMIT 5",nativeQuery = true)
//    List<Movie> getTop5Expensive();
//
}
