package com.ecommerce.controller;

import com.ecommerce.dto.CartItemsDTO;
import com.ecommerce.service.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class CartItemsController {

    @Autowired
    private CartItemsService cartItemsService;

    @PostMapping("/cartItems")
    public ResponseEntity<CartItemsDTO> createCartItems(@RequestBody CartItemsDTO cartItemsDTO){
        CartItemsDTO createdCartItems = cartItemsService.saveCartItems(cartItemsDTO);
        return new ResponseEntity<>(createdCartItems, HttpStatus.CREATED);
    }

    @PutMapping("/cartItems")
    public ResponseEntity<CartItemsDTO> updateCartItems(@RequestBody CartItemsDTO cartItemsDTO){
        CartItemsDTO updatedCartItemsDTO = cartItemsService.saveCartItems(cartItemsDTO);
        return new ResponseEntity<>(updatedCartItemsDTO, HttpStatus.CREATED);
    }

    @GetMapping("/cartItems")
    public ResponseEntity<List<CartItemsDTO>> getAllCartItems() {
        List<CartItemsDTO> cartItemsDTOListDTO = cartItemsService.getAllCartItems();
        return new ResponseEntity<>(cartItemsDTOListDTO,HttpStatus.OK);
    }

    @GetMapping("/cartItems/{id}")
    public ResponseEntity<CartItemsDTO> findUserById(@PathVariable Long id){
        CartItemsDTO CartItemsDTO = cartItemsService.getCartItems(id);
        return new ResponseEntity<>(CartItemsDTO,HttpStatus.OK);
    }

    @GetMapping("/cartItems/user/{userId}")
    public ResponseEntity<List<CartItemsDTO>> findCartItemsByUserId(@PathVariable Long userId) {
        List<CartItemsDTO> cartItemsList = cartItemsService.getCartIemsByUser(userId);
        return new ResponseEntity<>(cartItemsList, HttpStatus.OK);
    }

    @DeleteMapping("/cartItems/{id}")
    public ResponseEntity<Void> deleteCartItems(@PathVariable Long id) {
        cartItemsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
