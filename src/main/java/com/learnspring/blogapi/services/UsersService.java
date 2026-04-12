package com.learnspring.blogapi.services;

import com.learnspring.blogapi.dto.request.UsersRequest;
import com.learnspring.blogapi.dto.response.UsersResponse;
import com.learnspring.blogapi.models.Users;
import com.learnspring.blogapi.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    public List<UsersResponse> getAllUsers() {
        List<UsersResponse> response = new ArrayList<>();

        for(Users user : usersRepo.findAll()){
            UsersResponse dto = new UsersResponse();
            dto.setId(user.getUserId());
            dto.setUsername(user.getUsername());
            response.add(dto);
        }
        return response;
    }

    public UsersResponse getUserByUsername(String username) {
        Users user = usersRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UsersResponse response = new UsersResponse();

        response.setId(user.getUserId());
        response.setUsername(user.getUsername());

        return response;
    }

    public String addUser(Users user) {
        usersRepo.save(user);
        return "User Saved Successfully";
    }

}
