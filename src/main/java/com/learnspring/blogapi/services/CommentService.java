package com.learnspring.blogapi.services;

import com.learnspring.blogapi.dto.request.CommentRequest;
import com.learnspring.blogapi.dto.response.CommentResponse;
import com.learnspring.blogapi.models.Comment;
import com.learnspring.blogapi.models.Post;
import com.learnspring.blogapi.repos.CommentRepo;
import com.learnspring.blogapi.repos.PostRepo;
import com.learnspring.blogapi.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private UsersRepo usersRepo;

    private CommentResponse setValues(Comment comment) {
        CommentResponse response = new CommentResponse();

        response.setCommentId(comment.getCommentId());
        response.setCommenterUsername(comment.getCommenter().getUsername());
        response.setTimestamp(comment.getTimestamp());
        response.setPostId(comment.getPost().getPostId());
        response.setCommentContent(comment.getCommentContent());

        return response;
    }

    public List<CommentResponse> getCommentsByPostId(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new RuntimeException("Post Not found")
        );

        List<CommentResponse> commentResponses = new ArrayList<>();
        List<Comment> comments = commentRepo.findByPost(post);

        for(Comment comment : comments) {
            commentResponses.add(setValues(comment));
        }

        return commentResponses;
    }

    public CommentResponse getCommentById(Integer commentId) {
        Comment comment = commentRepo.findById(commentId).orElseThrow(
                () -> new RuntimeException("Comment Not found")
        );

        return setValues(comment);
    }

    public String addComment(Integer postId, CommentRequest commentRequest) {
        Comment newComment = new Comment();

        newComment.setCommentContent(commentRequest.getContent());
        newComment.setPost(
                postRepo.findById(postId).orElseThrow(
                        () -> new RuntimeException("Invalid Post ID")
                )
        );
        newComment.setCommenter(
                usersRepo.findByUsername(commentRequest.getUsername())
                        .orElseThrow(
                                () -> new RuntimeException("User not found")
                        )
        );

        commentRepo.save(newComment);

        return "Comment added to post %d successfully".formatted(postId);
    }
}
