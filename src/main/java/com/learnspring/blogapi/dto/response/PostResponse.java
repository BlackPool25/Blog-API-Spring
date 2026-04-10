package com.learnspring.blogapi.dto.response;

import java.time.LocalDateTime;

public class PostResponse {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime timestamp;
    private String authorName;

    public PostResponse() {
    }

    public PostResponse(Integer id, String title, String content, LocalDateTime timestamp, String authorName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.authorName = authorName;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
