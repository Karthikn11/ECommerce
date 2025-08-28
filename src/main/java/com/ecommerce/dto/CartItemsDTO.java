package com.ecommerce.dto;
import com.ecommerce.entity.User;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemsDTO {
    private Long id;
    private Integer quantity;
    private Double cost;
    private Long userId;
    private ProductDTO product;

}
