package com.example.labb2.service.interfaces;

import com.example.labb2.dto.model.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<CategoryDto> getAllCategories();
    Optional<CategoryDto> getCategoryById(long categoryId);
    void createCategory(String name, String symbol, String description);
}
