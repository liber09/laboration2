package com.example.labb2.service;

import com.example.labb2.dto.model.CategoryDto;
import com.example.labb2.exception.NotFoundException;
import com.example.labb2.model.Category;
import com.example.labb2.repository.CategoryRepository;
import com.example.labb2.service.interfaces.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    CategoryRepository repository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }
    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public Optional<CategoryDto> getCategoryById(long categoryId) {

        var result = map(repository.findById(categoryId));
        if (result.isPresent()){
            return result;
        }else{
            throw new NotFoundException("Category with the id " + categoryId + " was not found.");
        }
    }

    @Override
    public Category createCategory(CategoryDto category) {
        var categoryCheck = repository.getCategoryByName(category.name());
        if (categoryCheck.isEmpty()) {
            return save(category);
        }
        throw new IllegalArgumentException("Category with the name " + category.name() + " already exist.");
    }

    public Category save(CategoryDto category) {
        Category categoryEntity = new Category();
        categoryEntity.setName(category.name());
        categoryEntity.setSymbol(category.symbol());
        categoryEntity.setCreatedAt(category.createdAt());
        categoryEntity.setChangedAt(category.changedAt());
        categoryEntity.setDescription(category.description());
        return repository.save(categoryEntity);
    }
    static Optional<CategoryDto> map(Optional<Category> category){
        if(category.isEmpty()){
            return Optional.empty();
        }
        var mapCategory = category.get();
        return Optional.of(
                new CategoryDto(mapCategory.getCategoryId(), mapCategory.getName(), mapCategory.getSymbol(), mapCategory.getDescription(),
                        mapCategory.getCreatedAt(), mapCategory.getChangedAt()
                ));
    }
}
