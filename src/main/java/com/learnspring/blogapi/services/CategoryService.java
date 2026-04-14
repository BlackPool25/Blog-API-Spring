package com.learnspring.blogapi.services;

import com.learnspring.blogapi.dto.response.PostResponse;
import com.learnspring.blogapi.models.Category;
import com.learnspring.blogapi.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public String addCategory(Category category) {
        Category newCategory = new Category();

        newCategory.setCategoryName(category.getCategoryName());
        newCategory.setCategoryDescription(category.getCategoryDescription());

        categoryRepo.save(newCategory);

        return "Category %s added successfully".formatted(category.getCategoryName());
    }

    public String removeCategory(String categoryName) {
        Category category = categoryRepo.findCategoryByCategoryName(categoryName);

        if(category == null) {
            throw new RuntimeException("Category not found");
        }

        categoryRepo.delete(category);

        return "Category %s deleted successfully";
    }

    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    public Category getCategoryByName(String categoryName) {
        return categoryRepo.findCategoryByCategoryName(categoryName);
    }

}
