package com.example.labb2.service;

import com.example.labb2.dto.model.CategoryDto;
import com.example.labb2.model.Category;
import com.example.labb2.repository.CategoryRepository;
import com.example.labb2.service.interfaces.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    CategoryRepository repository;
    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Optional<CategoryDto> getCategoryById(long categoryId) {
        return map(repository.findById(categoryId));
    }

    @Override
    public void createCategory(String name, String symbol, String description) {

    }
    static Optional<CategoryDto> map(Optional<Category> category){
        if(category.isEmpty()){
            return Optional.empty();
        }
        var mapCategory = category.get();
        return Optional.of(
                new CategoryDto(mapCategory.getCategoryId(), mapCategory.getName(), mapCategory.getSymbol(), mapCategory.getDescription(),
                        mapCategory.getLocations()
                ));
    }
}
