package com.ecommerce.service;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;

import java.util.List;

public interface ProductService {

    ProductDTO save(ProductDTO product);

    List<ProductDTO> getAllUProduct();

    ProductDTO findproductById(Long id);

    List<ProductDTO> findProductsByCategory(Long id);
}
