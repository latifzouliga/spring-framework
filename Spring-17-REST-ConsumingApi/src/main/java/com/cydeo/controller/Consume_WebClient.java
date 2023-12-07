package com.cydeo.controller;

import com.cydeo.entity.Genre;
import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieCinemaRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class Consume_WebClient {


    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    // ========================= creating API using reactive programming =========================
    @GetMapping("flux-movie-cinema")
    public Flux<MovieCinema> readAllMovieCinemaFlux() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }


//    @GetMapping("/mono-movie-cinema/{id}")
//    private Mono<MovieCinema> readById(@PathVariable("id") Long id){
//        return Mono.just(movieCinemaRepository.findById(id).get());
//    }

    @GetMapping("/mono-movie-cinema/{id}")
    private ResponseEntity<Mono<MovieCinema>> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
    }

    @PostMapping("/create-genre")
    public Mono<Genre> create(@RequestBody Genre genre) {
//        Genre createdGenre = genreRepository.save(genre);
//        return Mono.just(createdGenre);
        return Mono.just(genreRepository.save(genre));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id) {
        genreRepository.deleteById(id);
        return Mono.empty();
    }


    // ========================= WebClient - Consuming API =========================


    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();


    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient() {
        return webClient
                .get()
                //.method(HttpMethod.GET)
                .uri("/flux-movie-cinema")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinema.class); // map to MovieCinema class
    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable Long id){
        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }


    @GetMapping("/flux-users")
    public Flux<Object> getAllFluxUsers() {
        return WebClient
                .builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
                .get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(Object.class);
    }

    @GetMapping("/mono-user/{id}")
    public ResponseEntity<Mono<Object>> getMonoUser(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("My-date", LocalDate.now().toString())
                .header("Modified-by","zouliga")
                .body(WebClient
                .builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()
                .get()
                .uri("/users/{id}" + id)
                .retrieve()
                .bodyToMono(Object.class));
    }

}
