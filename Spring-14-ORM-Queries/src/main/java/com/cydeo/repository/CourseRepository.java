package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.stream.Stream;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // find all coursed by category
    List<Course> findByCategory(String category);

    // find all courses bt category abs order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    // check if a course with the provided name exists, return true if course exists, otherwise return false
    Boolean existsCourseByName(String name);

    // return the count of courses for the provided category
    Integer countByCategory(String category);

    // find all courses that start with the provided course name
    List<Course> findByNameStartingWith(String name);

    // find all courses by category and return stream

    Stream<Course> streamByCategory(String category);

    @Query("SELECT c FROM Course c where c.category = :category AND c.rating > :rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);



}













