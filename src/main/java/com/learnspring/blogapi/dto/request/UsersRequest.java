package com.learnspring.blogapi.dto.request;

public class UsersRequest {
    private String Username;

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
