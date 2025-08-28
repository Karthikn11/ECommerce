package com.ecommerce.service;

import com.ecommerce.dto.OrderItemsDTO;
import com.ecommerce.entity.CartItems;

import java.util.List;

public interface OrderItemsService {


    OrderItemsDTO saveOrderItems(OrderItemsDTO orderItemsDTO);

    List<OrderItemsDTO> getAllOrderItems();

    OrderItemsDTO getOrderItems(Long id);

    void deleteOrderItems(Long id);
}
