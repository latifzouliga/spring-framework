package com.cydeo.bootstrap;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import com.cydeo.repository.AccountRepository;
import com.cydeo.repository.CinemaRepository;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.UserRepository;
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



    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n******************************************************");
        System.out.println("******************************************************");
        System.out.println("******************************************************\n");

        genreRepository.getAllGenreStartsWith("A").forEach(System.out::println);

        System.out.println("\n******************************************************");
        System.out.println("******************************************************");
        System.out.println("******************************************************\n");


    }
}
