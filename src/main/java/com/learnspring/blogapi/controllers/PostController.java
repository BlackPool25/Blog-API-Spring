package com.learnspring.blogapi.controllers;

import com.learnspring.blogapi.dto.response.PostResponse;
import com.learnspring.blogapi.models.Post;
import com.learnspring.blogapi.dto.request.PostRequest;
import com.learnspring.blogapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/byId")
    public Post getPostById(Integer postId) {
        return postService.getPostById(postId);
    }

    @PostMapping("/create-post")
    public ResponseEntity<PostResponse> createPost(
            @RequestBody PostRequest request,
            Authentication authentication) {
        PostResponse response =  postService.createPost(request, authentication);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
