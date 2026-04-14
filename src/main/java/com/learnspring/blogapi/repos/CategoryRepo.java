package com.learnspring.blogapi.repos;

import com.learnspring.blogapi.dto.response.PostResponse;
import com.learnspring.blogapi.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findCategoryByCategoryName(String categoryName);
}
