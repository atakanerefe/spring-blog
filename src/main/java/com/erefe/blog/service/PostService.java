package com.erefe.blog.service;

import com.erefe.blog.entity.Category;
import com.erefe.blog.entity.Post;
import com.erefe.blog.repository.CategoryRepository;
import com.erefe.blog.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public PostService(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    public Post save(Long categoryId, Post post) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found") );
        post.setCategory(category);
        return postRepository.save(post);
    }

    public List<Post> findByCategory(Long categoryId) {
        return postRepository.findByCategoryId(categoryId);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post Not Found"));
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
