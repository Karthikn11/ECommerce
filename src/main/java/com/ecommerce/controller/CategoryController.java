package com.ecommerce.controller;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO category) {
        CategoryDTO savedCategory = categoryService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/category")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO category) {
        CategoryDTO savedCategory = categoryService.saveCategory(category);
            return ResponseEntity.ok().body(category);

    }

    @GetMapping("/category")
    public  ResponseEntity<List<CategoryDTO>> getAllCategory(){
         List<CategoryDTO> categoriesList = categoryService.getAllCategories();
         return new ResponseEntity<>(categoriesList, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDTO> findCategoryById(@PathVariable Long id) {
            CategoryDTO category =  categoryService.getCategoryDetail(id);
            return new ResponseEntity<>(category,HttpStatus.OK);
       }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
