package com.ecommerce.dto;

import com.ecommerce.entity.Order;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsDTO {
    private Long id;
    private Integer quantity;
    private Double price;
    //private OrderDTO order;
    private ProductDTO product;
}
