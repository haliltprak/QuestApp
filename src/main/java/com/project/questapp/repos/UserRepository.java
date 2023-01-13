package com.project.questapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
