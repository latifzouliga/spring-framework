package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {

    // consuming 3rd party api
    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public User[] readAllUsers() {

        // getForEntity(): getting json object and mapping it to our POJOs
        // returning an array of users
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(URI, User[].class);

        //System.out.println(Arrays.toString(responseEntity.getBody()));
        return responseEntity.getBody();
    }

    @GetMapping("/{id}")
    public Object readUser(@PathVariable("id") Long id) {

        // getForObject: does not need DTOs  for customizing the json output
        // just get the json object and use it as is
        String URL = URI + "/{id}";
        return restTemplate.getForObject(URL, Object.class, id);
    }


    // passing headers

    //https://dummyapi.io/data/v1/user?limit=10
    //6298ebfecd0551211fce37a6

    @GetMapping("/test")
    public ResponseEntity<Object> consumeFromDummyApi(){
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Accept","Application/json");
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");

        // exchange(): passing some data

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

        return response;
    }


}
