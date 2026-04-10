package com.learnspring.blogapi.controllers;


import com.learnspring.blogapi.models.Users;
import com.learnspring.blogapi.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepo usersRepo;

    @GetMapping("/get-all-users")
    public List<Users> getAllUsers() {
        return usersRepo.findAll();
    }

    @GetMapping("/get-by-id")
    public Users getUser(String username) {
        return usersRepo.findByUsername(username).orElseThrow();
    }

    @PostMapping("/add-user")
    public String addUser(@RequestBody Users user) {
        usersRepo.save(user);
        return "User Saved Successfully";
    }

}
