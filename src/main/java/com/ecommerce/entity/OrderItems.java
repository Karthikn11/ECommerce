package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="price")
    private Double price;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
