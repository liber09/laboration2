package com.example.labb2.repository;

import com.example.labb2.model.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepository extends ListCrudRepository<Category, Long> {
}
