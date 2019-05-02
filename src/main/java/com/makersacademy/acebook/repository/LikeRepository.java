package com.makersacademy.acebook.repository;

import com.makersacademy.acebook.model.Like;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, Long> {
    List<Like> findByPostid(Long postid);
    List<Like> findByPostidAndUserid(Long postid, List<Long> userid);
}
