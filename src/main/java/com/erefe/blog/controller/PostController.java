package com.erefe.blog.controller;

import com.erefe.blog.mapper.PostMapper;
import com.erefe.blog.request.PostRequest;
import com.erefe.blog.response.PostResponse;
import com.erefe.blog.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    public PostController(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @GetMapping
    public List<PostResponse> getAllPosts() {
        return postService.findAll()
                .stream()
                .map(postMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable Long id) {
        return postMapper.toResponse(postService.findById(id));
    }

    @GetMapping("/category/{categoryId}")
    public List<PostResponse> getPostsByCategory(@PathVariable Long categoryId) {
        return postService.findByCategory(categoryId)
                .stream()
                .map(postMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/category/{categoryId}")
    public PostResponse createPost(@PathVariable Long categoryId, @RequestBody PostRequest postRequest) {
        var post = postMapper.toEntity(postRequest);
        var saved = postService.save(categoryId, post);
        return postMapper.toResponse(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
