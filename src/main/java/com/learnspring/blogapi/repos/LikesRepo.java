package com.learnspring.blogapi.repos;

import com.learnspring.blogapi.models.Likes;
import com.learnspring.blogapi.models.Post;
import com.learnspring.blogapi.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepo extends JpaRepository<Likes, Integer> {

    Likes findByPostAndUser(Post post, Users user);

    long countByPost_PostId(Integer postId);
}
