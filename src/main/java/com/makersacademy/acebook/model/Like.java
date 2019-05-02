package com.makersacademy.acebook.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "LIKES")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postid;
    private Long userid;

    private Like() {}

    public Like(Long postid, Long userid) {

        this.postid = postid;
        this.userid = userid;
    }


}

