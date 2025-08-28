package com.ecommerce.service;

import com.ecommerce.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO saveOrder(OrderDTO orderDTO);

    List<OrderDTO> getAllOrder();

    OrderDTO getOrder(Long id);

    OrderDTO placeOrder(Long userId);

    void cancelOrder(Long orderId);

    List<OrderDTO> getAllOrderByUser(Long userId);

}

