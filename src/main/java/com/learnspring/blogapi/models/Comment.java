package com.learnspring.blogapi.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id_post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private Users user;

    private String comment;
    private Timestamp timestamp;

    public Comment() {
    }

    public Comment(Integer id, Post post, Users user, String comment, Timestamp timestamp) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public Users getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
