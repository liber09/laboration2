package com.example.labb2.controller.v1;

import com.example.labb2.dto.model.CategoryDto;
import com.example.labb2.model.Category;
import com.example.labb2.service.CategoryService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
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

    @PostMapping
    @RolesAllowed("ADMIN")
    public ResponseEntity<Category> create(@RequestBody CategoryDto category) {
        var createdCategory = service.createCategory(category);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .buildAndExpand(createdCategory.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdCategory);
    }
}
