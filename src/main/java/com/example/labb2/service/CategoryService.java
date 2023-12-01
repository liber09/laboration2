package com.example.labb2.service;

import com.example.labb2.dto.model.CategoryDto;
import com.example.labb2.service.interfaces.ICategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Override
    public CategoryDto getAllCategories() {
        return null;
    }

    @Override
    public CategoryDto getCategoryById(long categoryId) {
        return null;
    }

    @Override
    public void createCategory(String name, String symbol, String description) {

    }
}
