package com.project.questapp.services;

import com.project.questapp.entity.User;
import com.project.questapp.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser( User newUser) {
        newUser.setId(0L);
        return userRepository.save(newUser);
    }

    public User getOneUser( Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser( Long userId,  User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }else {
            return null;
        }
    }

    public void deleteById( Long userId){
        userRepository.deleteById(userId);
    }

}
