package com.ecommerce.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String productName;
    private String productDescription;
    private Double price;
    private Integer quantity;
    private CategoryDTO category;
    private String brand;
}
