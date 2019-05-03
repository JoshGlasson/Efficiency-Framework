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

    private Long userid;


    public CommentForm(String content, Long post_id, Long userid) {
        this.content = content;
        this.post_id = post_id;
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}

