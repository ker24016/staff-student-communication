package com.byui.studentstaffcommunication.controller;

import com.byui.studentstaffcommunication.model.Post;
import com.byui.studentstaffcommunication.respoitory.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PostController {
    public PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable String id) {
        return postRepository.findById(id).orElse(null);
    }

    @GetMapping("post/{id}/replies")
    public List<Post> getPostByChildren(@PathVariable String id, @RequestParam(required = false) Integer count, @RequestParam(required = false) Integer page) {
        if (count == null) {
            count = 10;
        }
        if (page == null) {
            page = 0;
        }
        return postRepository.findByParentId(id, Pageable.ofSize(count).withPage(page));
    }

    @GetMapping("/author/{id}/posts")
    public List<Post> getPostsByAuthor(@PathVariable String id, @RequestParam(required = false) Integer count, @RequestParam(required = false) Integer page) {
        if (count == null) {
            count = 10;
        }
        if (page == null) {
            page = 0;
        }
        return postRepository.findByAuthorId(id, Pageable.ofSize(count).withPage(page));
    }
}
