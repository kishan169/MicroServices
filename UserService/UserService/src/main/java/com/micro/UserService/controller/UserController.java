package com.micro.UserService.controller;

import com.micro.UserService.exception.ResourceNotFoundException;
import com.micro.UserService.model.Rating;
import com.micro.UserService.model.User;
import com.micro.UserService.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users =  userService.getAllUser();
        return new ResponseEntity<List<User>>(users, HttpStatus.ACCEPTED);
    }
    @PostMapping
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        User savedUser =  userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserwithId(@PathVariable String userId) throws ResourceNotFoundException {

        User user = userService.getUser(userId);
        List<Rating> ratings =   this.restTemplate.getForObject("http://localhost:8090/ratings/users/"+userId,List.class);
        user.setRatings(ratings);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
