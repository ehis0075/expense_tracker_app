package com.example.codeengine.expense.controller;


import com.example.codeengine.expense.model.User;
import com.example.codeengine.expense.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    Collection<User> users() {

        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user")
    ResponseEntity<User> addUser(@Validated @RequestBody User user) throws URISyntaxException {
        User result = userRepository.save(user);
        return ResponseEntity.created(new URI("/api/user/" + result.getId())).body(result);
    }

    @PutMapping("/user/{id}")
    ResponseEntity<User> updateUser(@Validated @RequestBody User user){
        User result = userRepository.save(user);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/user/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
