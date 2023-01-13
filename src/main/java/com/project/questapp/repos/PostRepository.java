package com.project.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
