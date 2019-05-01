package com.makersacademy.acebook.model;

import javax.persistence.*;

import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String time_stamp;
    @Column(name = "post_id", nullable = false)
    private Long postid;

    private Comment() {}

    public Comment(String content, Long post_id) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        this.content = content;
        this.time_stamp = dateFormat.format(date);
        this.postid = post_id;
    }


}
