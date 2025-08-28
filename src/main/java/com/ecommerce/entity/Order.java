package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ordered_date")
    private LocalDateTime orderedDate;

    @Column(name="status")
    private String status;

    @Column(name="amount")
    private Double amount;

    @Column(name="payment_type")
    private String paymentType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;



}
