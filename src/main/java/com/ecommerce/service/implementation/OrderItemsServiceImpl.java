package com.ecommerce.service.implementation;

import com.ecommerce.dto.OrderItemsDTO;
import com.ecommerce.entity.OrderItems;
import com.ecommerce.mapper.OrderItemsMapper;
import com.ecommerce.repository.OrderItemsRepository;
import com.ecommerce.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    private OrderItemsMapper orderItemsMapper;

    @Override
    public OrderItemsDTO saveOrderItems(OrderItemsDTO orderItemsDTO) {
        OrderItems orderItems = orderItemsMapper.toEntity(orderItemsDTO);
        return orderItemsMapper.toDto(orderItems);
    }

    @Override
    public List<OrderItemsDTO> getAllOrderItems() {
        List<OrderItems> orderItemsList =  orderItemsRepository.findAll();
        return orderItemsMapper.toDto(orderItemsList);
    }

    @Override
    public OrderItemsDTO getOrderItems(Long id) {
        OrderItems orderItems = orderItemsRepository.findById(id).orElse(null);
        return orderItemsMapper.toDto(orderItems);
    }

    @Override
    public void deleteOrderItems(Long id) {
        orderItemsRepository.deleteById(id);
    }
}
