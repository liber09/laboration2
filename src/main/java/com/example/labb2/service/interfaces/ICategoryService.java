package com.example.labb2.service.interfaces;

import com.example.labb2.dto.model.CategoryDto;

public interface ICategoryService {
    CategoryDto getAllCategories();
    CategoryDto getCategoryById(long categoryId);
    void createCategory(String name, String symbol, String description);
}
