package com.project.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
    //List<Post> finbByUserId(Long userId);
}
