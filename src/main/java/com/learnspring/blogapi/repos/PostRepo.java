package com.learnspring.blogapi.repos;

import com.learnspring.blogapi.dto.response.PostResponse;
import com.learnspring.blogapi.models.Category;
import com.learnspring.blogapi.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
}
