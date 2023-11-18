package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> getCinemaByName(String name);

    @Query("SELECT c FROM Cinema c WHERE c.name = ?1")
    Cinema getCinemaByNameJPQL(String name);

    @Query(value = "SELECT * FROM cinema WHERE name = :name", nativeQuery = true)
    Cinema getCinemaByNameSQL(@Param("name") String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name

    List<Cinema> getTop3BySponsoredNameContainsOrderByName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country

    List<Cinema> findCinemaByLocation_Country(String country);


    // @Query("SELECT c FROM Cinema c JOIN Location l ON l.id = c.location.id WHERE l.country = ?1" )
    @Query("SELECT c FROM Cinema c WHERE c.location.country = ?1")
    List<Cinema> findCinemaByCountryJPQL(String country);

    @Query(value = "SELECT * FROM cinema c JOIN location l on c.location_id = l.id WHERE l.country = :country" , nativeQuery = true)
    List<Cinema> findCinemaByCountrySQL(@Param("country") String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findCinemaByNameOrSponsoredName(String name, String sponsoredName);

    @Query("SELECT c FROM Cinema c WHERE c.name = :name OR c.sponsoredName = :name")
    List<Cinema> findByNameOrSponsoredNameJPQL(@Param("name") String name);

    @Query(value = "SELECT * FROM cinema WHERE name = ?1 OR sponsored_name = ?1",nativeQuery = true)
    List<Cinema> findByNameOrSponsoredNameSQL(String name);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c.name FROM Cinema c WHERE c.id = :id")
    String findCinemaByIdJPQL(@Param("id") Long id);

    @Query(value = "SELECT * FROM cinema WHERE id = ?1", nativeQuery = true)
    Cinema findCinemaByIdSQL(Long id);



    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country

    @Query(value = "SELECT * FROM cinema c JOIN location l ON c.location_id = l.id WHERE l.country = ?1" , nativeQuery = true)
    List<Cinema> getAllCinemaByCountry(String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern

    @Query(value = "SELECT * FROM cinema WHERE " +
            "name           LIKE '%' || ?1 || '%'  OR " +
            "sponsored_name LIKE '%' || ?1 || '%'", nativeQuery = true)
    List<Cinema> getAllCinemasByNameOrSponsoredNameContains(String pattern);

    //Write a native query to sort all cinemas by name

    @Query(value = "SELECT * FROM cinema order by name", nativeQuery = true)
    List<Cinema> findAllCinemasSortedBName();



    //Write a native query to distinct all cinemas by sponsored name

    @Query(value = "SELECT DISTINCT sponsored_name FROM cinema", nativeQuery = true)
    List<String> getDistinctBySponsoredName();












}
