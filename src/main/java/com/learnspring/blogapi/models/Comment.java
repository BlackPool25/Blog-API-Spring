package com.learnspring.blogapi.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, name = "comment_id")
    private Integer commentId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users commenter;

    private String commentContent;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp timestamp;

    public Comment() {
    }

    public Integer getCommentId() {
        return commentId;
    }

    public Users getCommenter() {
        return commenter;
    }

    public void setCommenter(Users commenter) {
        this.commenter = commenter;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
