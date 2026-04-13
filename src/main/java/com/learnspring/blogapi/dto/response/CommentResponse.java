package com.learnspring.blogapi.dto.response;


import java.sql.Timestamp;

public class CommentResponse {
    private Integer commentId;
    private Integer postId;
    private String commenterUsername;
    private String commentContent;
    private Timestamp timestamp;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getCommenterUsername() {
        return commenterUsername;
    }

    public void setCommenterUsername(String commenterUsername) {
        this.commenterUsername = commenterUsername;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public CommentResponse() {
    }

    @Override
    public String toString() {
        return "CommentResponse{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", commenterUsername='" + commenterUsername + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
