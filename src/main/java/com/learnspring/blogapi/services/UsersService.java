package com.learnspring.blogapi.services;

import com.learnspring.blogapi.dto.request.LoginRequest;
import com.learnspring.blogapi.dto.request.UsersRequest;
import com.learnspring.blogapi.dto.response.UsersResponse;
import com.learnspring.blogapi.models.Users;
import com.learnspring.blogapi.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepo.save(user);
        return "User Saved Successfully";
    }

    public String verify(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(loginRequest.getUsername());
        }

        return "Failure";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepo.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("User not found")
                );

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities("USER")
                .build();
    }
}
