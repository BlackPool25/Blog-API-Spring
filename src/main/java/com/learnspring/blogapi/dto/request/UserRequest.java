package com.learnspring.blogapi.dto.request;

public class UserRequest {
    private String Username;

    public UserRequest() {
    }

    public UserRequest(String username) {
        Username = username;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "Username='" + Username + '\'' +
                '}';
    }
}
