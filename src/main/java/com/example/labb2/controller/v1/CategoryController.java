package com.example.labb2.controller.v1;

import com.example.labb2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
}
