package com.makersacademy.acebook.model;

public class PostForm {

    private String content;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    private Long userid;

    public PostForm(String content, Long userid) {
        this.content = content;
        this.userid =userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
