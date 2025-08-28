package com.ecommerce.mapper;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO,Category> {
}
