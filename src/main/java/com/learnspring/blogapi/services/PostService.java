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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UsersRepo userRepo;

    private PostResponse setValues(Post post) {
        PostResponse dto = new PostResponse();
        dto.setPostId(post.getPostId());
        dto.setPublisherName(post.getPostPublisher().getUsername());
        dto.setPublisherId(post.getPostPublisher().getUserId());
        dto.setTimestamp(post.getTimestamp());
        dto.setTitle(post.getPostTitle());
        dto.setContent(post.getPostContent());

        return dto;
    }

    public List<PostResponse> getAllPosts() {
        List<Post> posts = postRepo.findAll();

        List<PostResponse> response = new ArrayList<>();

        for(Post post : posts) {
            response.add(setValues(post));
        }

        return response;
    }

    public PostResponse getPostById(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new RuntimeException("Post not found")
        );

        return setValues(post);
    }

    public PostResponse createPost(PostRequest request) {

        Post Post = new Post();
        Post.setPostTitle(request.getTitle());
        Post.setPostContent(request.getContent());
        Post.setPostPublisher(userRepo.findByUsername(request.getPublisher()).orElseThrow(
                () -> new RuntimeException("Invalid Username")
        ));
        Post savedPost = postRepo.save(Post);

        return setValues(savedPost);
    }

    public String deletePosts() {
        postRepo.deleteAll();

        return "Deleted all posts successfully";
    }
}
