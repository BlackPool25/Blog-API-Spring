package com.learnspring.blogapi.controllers;

import com.learnspring.blogapi.dto.request.CommentRequest;
import com.learnspring.blogapi.dto.response.CommentResponse;
import com.learnspring.blogapi.models.Comment;
import com.learnspring.blogapi.repos.CommentRepo;
import com.learnspring.blogapi.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("{postId}/get-comments")
    public List<CommentResponse> getCommentByPost(@PathVariable Integer postId){
        return commentService.getCommentsByPostId(postId);
    }

    @GetMapping("/comments/{commentId}")
    public CommentResponse getCommentById(@PathVariable Integer commentId) {
        return commentService.getCommentById(commentId);
    }

    @PostMapping("{postId}/add-comment")
    public String addCommend(@PathVariable Integer postId, @RequestBody CommentRequest commentRequest) {
        return commentService.addComment(postId, commentRequest);
    }

}
