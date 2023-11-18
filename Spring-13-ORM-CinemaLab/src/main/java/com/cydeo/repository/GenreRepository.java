package com.cydeo.repository;

import com.cydeo.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that return all genres
    @Query("SELECT g FROM Genre g")
    List<Genre> findAllGenreJPQL();

    @Query(value = "SELECT * FROM genre", nativeQuery = true)
    List<Genre> findAllGenreSQL();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns genres by containing name
    Optional<Genre> findGenreByNameContaining(String pattern);

    @Query("SELECT g FROM Genre g WHERE g.name LIKE '%'||?1||'%'")
    Genre findGenreByNameContainingJPQL(String pattern);

    @Query(value = "SELECT * FROM Genre WHERE name LIKE CONCAT('%',:pattern,'%')", nativeQuery = true)
    Genre findGenreByNameContainingSQL(@Param("pattern") String pattern);


    @Query(value = "SELECT name FROM Genre",nativeQuery = true)
    List<String> getAllGenre();

    @Query("SELECT g.name FROM Genre g WHERE g.name LIKE :pattern || '%'")
    List<String> getAllGenreStartsWith(@Param("pattern") String pattern);

}
