package com.blog.project.services.impl;

import com.blog.project.entities.Category;
import com.blog.project.exceptions.ResourceNotFoundException;
import com.blog.project.payloads.CategoryDto;
import com.blog.project.repositories.CategoryRepo;
import com.blog.project.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.dtoToCategory(categoryDto);
        Category savedCategory = this.categoryRepo.save(category);
        return this.categoryToDto(savedCategory);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer catId) {
        Category category = this.categoryRepo.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", " id ", catId));

        category.setCatDesc(categoryDto.getCatDesc());
        category.setCatDesc(categoryDto.getCatDesc());
        Category updatedCategory = this.categoryRepo.save(category);
        return this.categoryToDto(updatedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Integer catId) {
        Category category = this.categoryRepo.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", " id ", catId));
        return this.categoryToDto(category);

    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = categories.stream().map(category -> this.categoryToDto(category)).collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public void deleteCategory(Integer catId) {
        Category category = this.categoryRepo.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", " id ", catId));
        this.categoryRepo.delete(category);
    }

    public Category dtoToCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        return category;
    }

    public CategoryDto categoryToDto(Category category) {
        CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }
}
