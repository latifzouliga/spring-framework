package com.cydeo.bootstrap;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;



    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n******************************************************");
        System.out.println("******************************************************");
        System.out.println("******************************************************\n");

        ticketRepository.getTicketsBySearchValue("Tenet").forEach(System.out::println);

        System.out.println("\n******************************************************");
        System.out.println("******************************************************");
        System.out.println("******************************************************\n");


    }
}
