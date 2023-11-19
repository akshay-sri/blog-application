package com.blog.project.services;

import com.blog.project.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto category);

    CategoryDto updateCategory(CategoryDto category, Integer catId);

    CategoryDto getCategoryById(Integer catId);

    List<CategoryDto> getAllCategories();

    void deleteCategory(Integer catId);
}
