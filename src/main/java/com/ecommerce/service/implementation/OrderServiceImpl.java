package com.ecommerce.service.implementation;

import com.ecommerce.constants.GlobalConstants;
import com.ecommerce.dto.*;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItems;
import com.ecommerce.exception.BusinessValidationException;
import com.ecommerce.mapper.OrderMapper;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.mapper.UserMapper;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.service.CartItemsService;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private CartItemsService cartItemsService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;



    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        List<Order> orderList = orderRepository.findAll();
        return orderMapper.toDto(orderList);
    }

    @Override
    public OrderDTO getOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        return orderMapper.toDto(order);
    }


    @Transactional
    @Override
    public OrderDTO placeOrder(Long userId) {
        UserDTO user = userService.findUserById(userId);
        if (user == null) {
            throw new BusinessValidationException("User not found");
        }

        List<CartItemsDTO> cartItemsList = cartItemsService.getCartIemsByUser(userId);
        if (cartItemsList.isEmpty()) {
            throw new BusinessValidationException("No Products selected for placing order");
        }

        Order order = new Order();
        order.setOrderedDate(LocalDateTime.now());
        order.setUser(userMapper.toEntity(user));
        order.setStatus(GlobalConstants.PLACED_ORDER);
        order.setPaymentType(GlobalConstants.CASH_ON_DELIVERY);
        double totalCost = 0.0;
        List<OrderItems> orderItemsList = new ArrayList<>();
        for (CartItemsDTO cartItem : cartItemsList) {
            OrderItems orderItem = new OrderItems();
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getCost());
            ProductDTO productDTO = productService.findproductById(cartItem.getProduct().getId());


            if (productDTO.getQuantity() < cartItem.getQuantity()) {
                throw new BusinessValidationException(
                        "Insufficient stock for product: " + productDTO.getProductName()
                );
            }
            productDTO.setQuantity(productDTO.getQuantity() - cartItem.getQuantity());
            ProductDTO updatedProduct = productService.save(productDTO);
            orderItem.setProduct(productMapper.toEntity(updatedProduct));
            orderItem.setOrder(order);
            totalCost += cartItem.getCost();
            orderItemsList.add(orderItem);
        }
        order.setOrderItems(orderItemsList);
        order.setAmount(totalCost);

        try {
            Order savedOrder = orderRepository.save(order);
            cartItemsService.deleteByUserId(userId);
            return orderMapper.toDto(savedOrder);
        } catch (Exception e) {
            throw new RuntimeException("Failed to place order", e);
        }
    }

    @Override
    public void cancelOrder(Long orderId) {
        try {
            Order order = orderRepository.findById(orderId).orElseThrow(() -> new BusinessValidationException("Order not found"));
            if (order.getStatus().equalsIgnoreCase("CANCELLED")) {
                throw new BusinessValidationException("Order is already cancelled");
            }
            if (order.getStatus().equalsIgnoreCase("DELIVERED")) {
                throw new BusinessValidationException("Delivered order cannot be cancelled");
            }
            order.setStatus(GlobalConstants.CANCEL_ORDER);
            orderRepository.save(order);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to Cancel Order",e);
        }


    }

    @Override
    public List<OrderDTO> getAllOrderByUser(Long userId) {
        UserDTO userDTO = userService.findUserById(userId);
        if(userDTO == null) {
            throw new BusinessValidationException("User Not Found");
        }
        List<Order> orderList = orderRepository.findByUserId(userId);
        if (orderList.isEmpty()) {
            throw new BusinessValidationException("No Orders Found for this User");
        }
        return orderMapper.toDto(orderList);
    }
}
