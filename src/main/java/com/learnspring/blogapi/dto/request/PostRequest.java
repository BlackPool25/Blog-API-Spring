package com.learnspring.blogapi.dto.request;



public class PostRequest {
    private String title;
    private String content;
    private String publisher;

    public String getTitle() {
        return title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setAuthor(String publisher) {
        this.publisher = publisher;
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
