package com.byui.studentstaffcommunication.controller;

import com.byui.studentstaffcommunication.model.Post;
import com.byui.studentstaffcommunication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    public PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable String id) {
        return ResponseEntity.of(postRepository.findById(id));
    }

    @GetMapping("/{id}/replies")
    public ResponseEntity<List<Post>> getPostByChildren(@PathVariable String id,
                                        @RequestParam(defaultValue = "10") int count,
                                        @RequestParam(defaultValue = "0") int page) {
        return ResponseEntity.ok(postRepository.findAllByParent(postRepository.findById(id).orElseThrow(), Pageable.ofSize(count).withPage(page)));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>> getPostsByAuthor(@RequestParam(defaultValue = "") String query,
                                                      @RequestParam(defaultValue = "10") Integer count,
                                                      @RequestParam(defaultValue = "0") Integer page) {
        return ResponseEntity.ok(postRepository.findAllByAuthorIdContainingIgnoreCaseOrTitleContainingIgnoreCaseOrContentContainingIgnoreCase(query, query, query, Pageable.ofSize(count).withPage(page)));
    }
}
