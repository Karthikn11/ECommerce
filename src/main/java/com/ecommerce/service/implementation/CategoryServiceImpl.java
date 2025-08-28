package com.ecommerce.service.implementation;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.entity.Category;
import com.ecommerce.mapper.CategoryMapper;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.toDto(categoryRepository.findAll());
    }

    @Override
    public CategoryDTO getCategoryDetail(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return categoryMapper.toDto(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category != null){
            categoryRepository.deleteById(category.getId());
        }
    }
}
