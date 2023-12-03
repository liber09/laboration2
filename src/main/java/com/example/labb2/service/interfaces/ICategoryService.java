package com.example.labb2.service.interfaces;

import com.example.labb2.dto.model.CategoryDto;
import com.example.labb2.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getAllCategories();
    Optional<CategoryDto> getCategoryById(long categoryId);
    Category createCategory(CategoryDto category);
}
