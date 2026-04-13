package com.learnspring.blogapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "post_likes",
uniqueConstraints = @UniqueConstraint(columnNames = {"post_id", "user_id"}))
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Likes() {
    }

    public Likes(Integer id, Post post, Users user) {
        this.id = id;
        this.post = post;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Likes{" +
                "id=" + id +
                ", post=" + post +
                ", user=" + user +
                '}';
    }
}
