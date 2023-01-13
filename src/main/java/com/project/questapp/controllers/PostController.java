package com.project.questapp.controllers;

import com.project.questapp.entity.Post;
import com.project.questapp.request.PostCreateRequest;
import com.project.questapp.request.PostUpdateRequest;
import com.project.questapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){

        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPost){
        return postService.createOnePost(newPost);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePostRequest){
        return postService.updateOnePostById(postId,updatePostRequest);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
        postService.deleteOnePostById(postId);
    }

}
