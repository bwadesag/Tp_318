package com.example.tp318.service;

import com.example.tp318.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(String id);
    Category saveCategory(Category category);
    void deleteCategory(String id);
} 