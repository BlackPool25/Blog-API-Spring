package com.learnspring.blogapi.controllers;

import com.learnspring.blogapi.models.Category;
import com.learnspring.blogapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add-category")
    public String addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PostMapping("/remove-category")
    public String removeCategory(@RequestBody String categoryName) {
        return categoryService.removeCategory(categoryName);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("{categoryName}")
    public Category getCategoryById(@PathVariable String categoryName) {
        return categoryService.getCategoryByName(categoryName);
    }
}
