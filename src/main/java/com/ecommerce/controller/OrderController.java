package com.ecommerce.controller;

import com.ecommerce.dto.CartItemsDTO;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<OrderDTO> createOrders(@RequestBody OrderDTO orderDTO){
        OrderDTO createdOrder = orderService.saveOrder(orderDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    @PutMapping("/order")
    public ResponseEntity<OrderDTO> updateOrders(@RequestBody OrderDTO orderDTO){
        OrderDTO updatedOrderDTO = orderService.saveOrder(orderDTO);
        return new ResponseEntity<>(updatedOrderDTO, HttpStatus.CREATED);
    }

    @GetMapping("/order")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orderDTOListDTO = orderService.getAllOrder();
        return new ResponseEntity<>(orderDTOListDTO,HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDTO> findOrderById(@PathVariable Long id) {
        OrderDTO orderDTO = orderService.getOrder(id);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderDTO> placeOrder(@RequestParam Long userId) {
        OrderDTO orderDTO = orderService.placeOrder(userId);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    @PutMapping("/order/cancelOrder/{id}")
    public ResponseEntity<String> cancelOrders(@PathVariable Long id){
        orderService.cancelOrder(id);
        return new ResponseEntity<>("Order has been Cancelled", HttpStatus.OK);
    }

    @GetMapping("/order/userOrder/{id}")
    public ResponseEntity<List<OrderDTO>> findOrderByUserId(@PathVariable Long id) {
        List<OrderDTO> orderDTO = orderService.getAllOrderByUser(id);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }



}
