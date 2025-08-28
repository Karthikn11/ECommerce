package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product_master")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "brand")
    private String brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


}
