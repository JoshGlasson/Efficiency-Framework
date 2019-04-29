package com.makersacademy.acebook.model;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class PostFormTest {

    private PostForm post = new PostForm("hello");

    @Test
    public void postHasContent() {
        assertThat(post.getContent(), containsString("hello"));
    }


}
