package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    Optional<User> readByEmail(String email);

    List<User> readUserByEmail(String email);

    //Write a derived query to read a user with an username?
    Optional<User> readUserByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User> getAllByAccount_NameContains(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User> getAllByAccount_NameIgnoreCaseContains(String name);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> getAllByAccount_AgeGreaterThan(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?

    @Query("SELECT u FROM User u WHERE LOWER( u.email ) = LOWER( ?1 )")
    Optional<User> getUserByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> getByUsername(String username);

    //Write a JPQL query that returns all users?
    @Query("SELECT u FROM User u")
    List<User> getAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "SELECT * FROM user_account ua " +
            "JOIN account_details ad ON ua.account_details_id = ad.id  " +
            "WHERE ad.name ILIKE '%'||?1||'%'", nativeQuery = true)
    Optional<User> getByName(String name);

    //Write a native query that returns all users?
    @Query(value = "SELECT * FROM user_account", nativeQuery = true)
    List<User> getAccounts();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user_account ua " +
            "JOIN account_details ad ON ua.account_details_id = ad.id " +
            "WHERE ad.age BETWEEN ?1 AND ?2", nativeQuery = true)
    List<User> getUsersAgeBetween(Integer age1, Integer age2);

    //Write a native query to read a user by email?
    @Query(value = "SELECT * FROM user_account WHERE email ILIKE ?1", nativeQuery = true)
    Optional<User> findUserByEmail(String email);

}
