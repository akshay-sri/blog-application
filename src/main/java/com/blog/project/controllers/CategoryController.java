package com.blog.project.controllers;

import com.blog.project.payloads.ApiResponse;
import com.blog.project.payloads.CategoryDto;
import com.blog.project.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/categories/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/categories/update/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable(name = "catId") Integer cId) {
        CategoryDto updateCategoryDto = this.categoryService.updateCategory(categoryDto, cId);
        return ResponseEntity.ok(updateCategoryDto);
    }

    @GetMapping("/categories/{catId}")
    public ResponseEntity<CategoryDto> getUserById(@PathVariable(name = "catId") Integer cId) {
        return ResponseEntity.ok(this.categoryService.getCategoryById(cId));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getCategory() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/categories/delete/{catId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable(name = "catId") Integer cId) {
        this.categoryService.deleteCategory(cId);
        return new ResponseEntity(new ApiResponse("Category deleted successfully", true), HttpStatus.OK);
    }
}
