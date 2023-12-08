package com.cydeo.controller;

import com.cydeo.entity.Account;
import com.cydeo.entity.User;
import com.cydeo.repository.AccountRepository;
import com.cydeo.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Users", description = "Users CRUD Operations")
public class UserController {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserController(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/users")
    @Operation(summary = "Read all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved users (Ok)",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",description = "Something went wrong",content = @Content),
            @ApiResponse(responseCode = "404",description = "Not found",content = @Content)
    })
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "User created successfully",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400",description = "Bad request",content = @Content)

    })
    public ResponseEntity<User> createUser(@RequestBody User user){
        Account account = accountRepository.save(user.getAccount());
        user.setAccount(account);
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){

        userRepository.save(account.getUser());
        return ResponseEntity.ok(accountRepository.save(account));
    }

}
