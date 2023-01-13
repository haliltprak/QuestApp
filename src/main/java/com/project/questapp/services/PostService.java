package com.project.questapp.services;

import com.project.questapp.entity.Post;
import com.project.questapp.entity.User;
import com.project.questapp.repos.PostRepository;
import com.project.questapp.request.PostCreateRequest;
import com.project.questapp.request.PostUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserService userService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService){
        this.userService=userService;
        this.postRepository = postRepository;
    }
    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostCreateRequest) {
        User user = userService.getOneUser(newPostCreateRequest.getUserId());

        if(user == null){
            return null;
        }
        Post tempPost = new Post();
        tempPost.setId(newPostCreateRequest.getId());
        tempPost.setText(newPostCreateRequest.getText());
        tempPost.setTitle(newPostCreateRequest.getTitle());
        tempPost.setUser(user);
        return postRepository.save(tempPost);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest updatePostRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Post toPostUpdate = post.get();
            toPostUpdate.setText(updatePostRequest.getText());
            toPostUpdate.setTitle(updatePostRequest.getTitle());
            postRepository.save(toPostUpdate);
            return toPostUpdate;
        }
        return null;
    }

    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}

