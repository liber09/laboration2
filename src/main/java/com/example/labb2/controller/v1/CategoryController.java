package com.example.labb2.controller.v1;

import com.example.labb2.dto.model.CategoryDto;
import com.example.labb2.model.Category;
import com.example.labb2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService categoryService){
        this.service = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return service.getAllCategories();
    }
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        var categoryService = service.getCategoryById(id);

        return categoryService.map(categoryDto -> ResponseEntity.ok().body(categoryDto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
