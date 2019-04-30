package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Post, Long> {

}
