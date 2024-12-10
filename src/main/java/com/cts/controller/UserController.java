package com.cts.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dtos.UserRequestDTO;
import com.cts.entity.User;
import com.cts.service.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<User> getUserByIdPath(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping(path = "/usersById")
    public ResponseEntity<User> getUserByIdParam(@RequestParam Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> saveUser(@RequestBody @jakarta.validation.Valid UserRequestDTO userRequest) {
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }


}
