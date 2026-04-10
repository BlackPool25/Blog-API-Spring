package com.learnspring.blogapi.dto;

import org.antlr.v4.runtime.misc.NotNull;

public class PostRequest {
    private String title;
    private String content;

    public PostRequest() {
    }

    public PostRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
