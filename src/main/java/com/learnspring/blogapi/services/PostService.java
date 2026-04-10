package com.learnspring.blogapi.services;

import com.learnspring.blogapi.dto.response.PostResponse;
import com.learnspring.blogapi.models.Post;
import com.learnspring.blogapi.dto.request.PostRequest;
import com.learnspring.blogapi.models.Users;
import com.learnspring.blogapi.repos.PostRepo;
import com.learnspring.blogapi.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UsersRepo userRepo;

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post getPostById(Integer postId) {
        return postRepo.findById(postId).orElse(new Post());
    }

    public PostResponse createPost(PostRequest request, Authentication authentication) {

        String username = authentication.getName();

        Users user = userRepo.findByUsername(username)
                .orElseThrow( () -> new RuntimeException("User not found"));


        Post Post = new Post();
        Post.setPostTitle(request.getTitle());
        Post.setPostContent(request.getContent());
        Post.setPostPublisher(user);
        Post savedPost = postRepo.save(Post);

        PostResponse response = new PostResponse();
        response.setId(savedPost.getPostId());
        response.setTitle(savedPost.getPostTitle());
        response.setContent(savedPost.getPostContent());
        response.setTimestamp(savedPost.getTimestamp());
        response.setAuthorName(savedPost.getPostPublisher().getUsername());

        return response;
    }
}
