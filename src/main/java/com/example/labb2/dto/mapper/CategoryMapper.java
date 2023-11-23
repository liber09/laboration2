package com.example.labb2.dto.mapper;

import com.example.labb2.dto.CategoryDto;
import com.example.labb2.model.Category;

public class CategoryMapper {
    public static CategoryDto toCategoryDto(Category category){
        return new CategoryDto()
                .setId(category.getCategoryId())
                .setName(category.getName())
                .setDescription(category.getDescription())
                .setSymbol(category.getSymbol());
    }
}
