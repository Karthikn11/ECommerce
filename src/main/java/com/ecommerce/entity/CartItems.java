package com.ecommerce.entity;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_items")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name="cost")
    private Double cost;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private Product product;
}


