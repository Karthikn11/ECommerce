package com.ecommerce.service.implementation;

import com.ecommerce.dto.CartItemsDTO;
import com.ecommerce.entity.CartItems;
import com.ecommerce.exception.BusinessValidationException;
import com.ecommerce.mapper.CartItemsMapper;
import com.ecommerce.repository.CartItemsRepository;
import com.ecommerce.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemsServiceImpl implements CartItemsService {

    @Autowired
    private CartItemsRepository cartItemsRepository;

    @Autowired
    private CartItemsMapper cartItemsMapper;


    @Override
    public CartItemsDTO saveCartItems(CartItemsDTO cartItemsDTO) {
        try {
            if (cartItemsDTO != null && cartItemsDTO.getProduct().getQuantity() >= cartItemsDTO.getQuantity()) {
                CartItems cartItems = cartItemsMapper.toEntity(cartItemsDTO);
                return cartItemsMapper.toDto(cartItemsRepository.save(cartItems));
            } else {
                throw new BusinessValidationException("Requested quantity exceeds available product quantity.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to save cart items: " + e.getMessage(), e);
        }
    }


    @Override
    public List<CartItemsDTO> getAllCartItems() {
        List<CartItems> cartItemsList = cartItemsRepository.findAll();
        return cartItemsMapper.toDto(cartItemsList);
    }

    @Override
    public CartItemsDTO getCartItems(Long id) {
        return cartItemsRepository.findById(id)
                .map(cartItemsMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<CartItemsDTO> getCartIemsByUser(Long userId) {
        List<CartItems> cartItemsList = cartItemsRepository.findByUserId(userId);
        return cartItemsMapper.toDto(cartItemsList);
    }

    @Override
    public void deleteById(Long id) {
        cartItemsRepository.deleteById(id);
    }

    @Override
    public void deleteByUserId(Long userId) {
        cartItemsRepository.deleteByUserId(userId);
    }

}
