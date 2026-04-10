package com.learnspring.blogapi.repos;

import com.learnspring.blogapi.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
    Boolean existsByUsername(String username);
}
