package com.blogging.blogging.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="posts")
public class PostController {
    private final PostService postService;


    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/")
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @PostMapping("/")
    public void createPost(@RequestBody Post post){
        postService.createPost(post);
    }
}
