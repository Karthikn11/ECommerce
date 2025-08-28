package com.ecommerce.service;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    CategoryDTO saveCategory(CategoryDTO category);

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryDetail(Long id);

    void deleteCategory(Long id);
}
