package com.makersacademy.acebook.model;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostTest {

	private Post post = new Post("hello");

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date date = new Date();

	@Test
	public void postHasContent() {
		assertThat(post.getContent(), containsString("hello"));
	}

	@Test
	public void postHasDate() {assertThat(post.getDate(), containsString(dateFormat.format(date)));}

}
