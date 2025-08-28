package com.ecommerce.controller;

import com.ecommerce.dto.OrderItemsDTO;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.service.OrderItemsService;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    @PostMapping("/orderItems")
    public ResponseEntity<OrderItemsDTO> createOrderItems(@RequestBody OrderItemsDTO orderItemsDTO){
        OrderItemsDTO createdProduct = orderItemsService.saveOrderItems(orderItemsDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/orderItems")
    public ResponseEntity<OrderItemsDTO> updateOrderItems(@RequestBody OrderItemsDTO orderItemsDTO){
        OrderItemsDTO updatedProduct = orderItemsService.saveOrderItems(orderItemsDTO);
        return new ResponseEntity<>(updatedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/orderItems")
    public ResponseEntity<List<OrderItemsDTO>> getAllOrderItems() {
        List<OrderItemsDTO> orderItemsList = orderItemsService.getAllOrderItems();
        return new ResponseEntity<>(orderItemsList,HttpStatus.OK);
    }

    @GetMapping("/orderItems/{id}")
    public ResponseEntity<OrderItemsDTO> findOrderItemsById(@PathVariable Long id){
        OrderItemsDTO product = orderItemsService.getOrderItems(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping("/orderItems/{id}")
    public ResponseEntity<Void> deleteOrderItems(@PathVariable Long id) {
        orderItemsService.deleteOrderItems(id);
        return ResponseEntity.noContent().build();
    }



}
