package com.erefe.blog.service;

import com.erefe.blog.entity.Category;
import com.erefe.blog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category update(Long id, Category newData) {
        Category oldCategory = findById(id);
        oldCategory.setName(newData.getName());
        oldCategory.setDescription(newData.getDescription());
        return categoryRepository.save(oldCategory);
    }

}
