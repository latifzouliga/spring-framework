package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countByUserAccountId(Long id);

    //Write a derived query to list all tickets by specific email
    List<Ticket> getAllByUserAccount_Email(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    List<Ticket> countByMovieCinema_Movie_Name(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> getAllByDateTimeBetween(LocalDateTime date1, LocalDateTime date2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t where t.userAccount.id = ?1")
    List<Ticket> getTicketsBoughtByUser(Long id);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime BETWEEN ?1 and ?1")
    List<Ticket> getTicketsBetweenDates(LocalDate date1, LocalDateTime date2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    @Query(value = "SELECT * FROM ticket ",nativeQuery = true)
    Integer countAllTicketsBoughtByUser(Long id);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT * FROM ticket WHERE user_account_id = ?1 AND date_time BETWEEN ?2 AND ?3",nativeQuery = true)
    List<Ticket> ticketsBoughtByUserBetween(LocalDateTime date1,LocalDateTime date2);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT distinct(m.name) FROM ticket t " +
            "join movie_cinema mc ON t.movie_cinema_id = mc.id " +
            "JOIN movie m ON mc.movie_id = m.id",nativeQuery = true)
    List<String> getAllTicketsByMovieName();

    //Write a native query to find all tickets by user email

    @Query(value = "SELECT * FROM ticket t " +
            "JOIN user_account ua ON t.user_account_id = ua.id " +
            "WHERE ua.username = ?1",nativeQuery = true)
    List<Ticket> getAllTicketsByUserEmail(String email);

    //Write a native query that returns all tickets

    @Query(value = "SELECT * FROM ticket", nativeQuery = true)
    List<Ticket> fetchAllTickets();

    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(value = "SELECT * FROM ticket t " +
            "JOIN user_account ua ON t.user_account_id = ua.id " +
            "JOIN account_details ad ON ua.account_details_id = ad.id " +
            "JOIN movie_cinema mc on t.movie_cinema_id = mc.id " +
            "JOIN movie m ON mc.movie_id = m.id " +
            "WHERE ua.username ILIKE '%'||?1||'%' OR ad.name ILIKE '%'||?1||'%' OR m.name ILIKE '%'||?1||'%'", nativeQuery = true)
    List<Ticket> getTicketsBySearchValue(String pattern);



}
