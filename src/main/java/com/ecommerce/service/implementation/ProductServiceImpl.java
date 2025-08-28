package com.ecommerce.service.implementation;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository,ProductMapper productMapper) {
        this.productRepository =  productRepository;
        this.productMapper =  productMapper;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO) ;
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public List<ProductDTO> getAllUProduct() {
        List<Product> productDTOList = productRepository.findAll();
      return productMapper.toDto(productDTOList);
    }

    @Override
    public ProductDTO findproductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDTO> findProductsByCategory(Long id) {
        List<Product> productLists = productRepository.findProductByCategoryId(id);
        return productLists.stream().map(productMapper::toDto).toList();
    }
}
