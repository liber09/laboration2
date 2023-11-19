package com.example.labb2.service;

import com.example.labb2.dto.CategoryDto;

public interface categoryService {
    CategoryDto getAllCategories();
    CategoryDto getCategoryById(int categoryId);
    void createCategory(String name, String symbol, String description);
}
