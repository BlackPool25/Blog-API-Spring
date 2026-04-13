package com.learnspring.blogapi.dto.request;

import jakarta.persistence.Column;

public class CommentRequest {
    private String username;

    @Column(length = 1000)
    private String content;

    public CommentRequest() {
    }

    public CommentRequest(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentRequest{" +
                "username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
