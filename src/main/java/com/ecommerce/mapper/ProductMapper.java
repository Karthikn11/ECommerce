package com.ecommerce.mapper;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
}
