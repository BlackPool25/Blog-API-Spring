package com.learnspring.blogapi.services;

import com.learnspring.blogapi.models.Likes;
import com.learnspring.blogapi.models.Post;
import com.learnspring.blogapi.models.Users;
import com.learnspring.blogapi.repos.LikesRepo;
import com.learnspring.blogapi.repos.PostRepo;
import com.learnspring.blogapi.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LikesService {

    @Autowired
    private LikesRepo likesRepo;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private PostRepo postRepo;

    public String addLike(Integer postId, Authentication authentication) {
        String username = authentication.getName();
        Users user = usersRepo.findByUsername(username).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        Post post = postRepo.findById(postId).orElseThrow(
                () -> new RuntimeException("Post not found")
        );

        Likes like = new Likes();
        like.setPost(post);
        like.setUser(user);

        likesRepo.save(like);

        return "Like added successfully to post %d by user %s".formatted(postId, user.getUsername());
    }

    public long getLikes(Integer postId) {

        if(postRepo.findById(postId).isEmpty()) {
            throw new RuntimeException("Post with id %d doesn't exist".formatted(postId));
        }

        return likesRepo.countByPost_PostId(postId);
    }

    public String removeLike(Integer postId, Authentication authentication) {

        String username = authentication.getName();

        Users user = usersRepo.findByUsername(username)
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );

        Post post = postRepo.findById(postId)
                .orElseThrow(
                        () -> new RuntimeException("Post not found")
                );

        Likes like = likesRepo.findByPostAndUser(post, user);

        likesRepo.delete(like);

        return "Like deleted from %d post from user %s".formatted(postId, user.getUsername());

    }
}
