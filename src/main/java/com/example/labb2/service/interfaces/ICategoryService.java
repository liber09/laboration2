package com.example.labb2.service.interfaces;

import com.example.labb2.dto.model.CategoryDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(long categoryId);
    void createCategory(String name, String symbol, String description);
}
