package com.cydeo.bootstrap;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;
    private final MovieRepository movieRepository;



    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n******************************************************");
        System.out.println("******************************************************");
        System.out.println("******************************************************\n");

//        System.out.println(cinemaRepository.getCinemaByName("Hall 1 - EMPIRE"));
//        System.out.println(accountRepository.getAdminAccounts());
//        System.out.println(cinemaRepository.find);
//        System.out.println(movieRepository.fetchAllMovieNames());
//        System.out.println(movieCinemaRepository.countByCinemaId(4L));
//        System.out.println(movieCinemaRepository.("AMC Empire 25"));
//        System.out.println(ticketRepository.fetchAllTicketsByUserAccount(4L));
//        System.out.println(ticketRepository.fetchAllTicketsBetweenRangeOfDateTimes(LocalDateTime.now().minusDays(1000), LocalDateTime.now()));
//        System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));
//        System.out.println(genreRepository.fetchAll());
//        System.out.println(userRepository.fetchAllUsers());

        System.out.println("\n******************************************************");
        System.out.println("******************************************************");
        System.out.println("******************************************************\n");


    }
}
