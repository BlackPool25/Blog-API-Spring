package com.learnspring.blogapi.controllers;


import com.learnspring.blogapi.dto.request.LoginRequest;
import com.learnspring.blogapi.dto.request.UsersRequest;
import com.learnspring.blogapi.dto.response.UsersResponse;
import com.learnspring.blogapi.models.Users;
import com.learnspring.blogapi.repos.UsersRepo;
import com.learnspring.blogapi.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepo usersRepo;
    @Autowired
    private UsersService usersService;

    @GetMapping("/get-all-users")
    public List<UsersResponse> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers()).getBody();
    }

    @GetMapping("/{username}")
    public UsersResponse getUser(@PathVariable String username) {
        return ResponseEntity.ok(usersService.getUserByUsername(username)).getBody();
    }

    @PostMapping("/api/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return usersService.verify(loginRequest);
    }

    @PostMapping("/add-user")
    public String addUser(@RequestBody Users user) {
        return usersService.addUser(user);
    }

}
