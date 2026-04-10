package com.learnspring.blogapi.repos;

import com.learnspring.blogapi.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {
}
