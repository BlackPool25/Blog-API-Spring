package com.learnspring.blogapi.models;

import jakarta.persistence.*;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String postTitle;

    @ManyToOne
    @JoinColumn(name = "post_publisher_user_id")
    private Users postPublisher;

    private String postContent;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime timestamp;

    public Users getPostPublisher() {
        return postPublisher;
    }

    public void setPostPublisher(Users postPublisher) {
        this.postPublisher = postPublisher;
    }

    public Post() {
    }

    public Post(String postTitle, Integer postId, Users postPublisher, String postContent, LocalDateTime timestamp) {
        this.postTitle = postTitle;
        this.postId = postId;
        this.postPublisher = postPublisher;
        this.postContent = postContent;
        this.timestamp = timestamp;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public Integer getPostId() {
        return postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }


    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postPublisher=" + postPublisher +
                ", postContent='" + postContent + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
