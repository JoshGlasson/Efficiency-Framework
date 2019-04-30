package com.makersacademy.acebook.model;

public class CommentForm {

    private String content;

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    private Long post_id;


    public CommentForm(String content, Long post_id) {
        this.content = content;
        this.post_id = post_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}

