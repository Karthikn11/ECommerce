package com.ecommerce.service;

import com.ecommerce.dto.CartItemsDTO;
import com.ecommerce.entity.CartItems;

import java.util.List;

public interface CartItemsService {

    CartItemsDTO saveCartItems(CartItemsDTO cartItems);

    List<CartItemsDTO> getAllCartItems();

    CartItemsDTO getCartItems(Long id);

    List<CartItemsDTO> getCartIemsByUser(Long userId);

    void deleteById(Long id);

    void deleteByUserId(Long userId);
}
