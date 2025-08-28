package com.ecommerce.dto;

import com.ecommerce.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable {
    private Long id;

    private LocalDateTime orderedDate;

    private String status;

    private Double amount;

    private String paymentType;

    private UserDTO user;

    private List<OrderItemsDTO> orderItems;


}
