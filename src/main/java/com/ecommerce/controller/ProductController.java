package com.ecommerce.controller;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product){
        ProductDTO createdProduct = productService.save(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/product")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product){
        ProductDTO updatedProduct = productService.save(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        List<ProductDTO> productList = productService.getAllUProduct();
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable Long id){
        ProductDTO product = productService.findproductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @GetMapping("/product/category/{id}")
    public  ResponseEntity<List<ProductDTO>> findProductByCategory(@PathVariable Long id){
      List<ProductDTO> productDTOList = productService.findProductsByCategory(id);
      return new ResponseEntity<>(productDTOList,HttpStatus.OK);
    }

}
