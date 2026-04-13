package com.learnspring.blogapi.services;


import com.learnspring.blogapi.models.Users;
import com.learnspring.blogapi.repos.UsersRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordMigrationService {

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void migrate() {
        List<Users> users = usersRepo.findAll();

        for(Users user: users) {
            String rawPassword = user.getPassword();


            if(!rawPassword.startsWith("$2a$") && !rawPassword.startsWith("$2b$")) {
                String encodedPassword = passwordEncoder.encode(rawPassword);

                user.setPassword(encodedPassword);
                usersRepo.save(user);
            }
        }
    }
}
