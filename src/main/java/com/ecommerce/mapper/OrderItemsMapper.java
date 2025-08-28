package com.ecommerce.mapper;

import com.ecommerce.dto.OrderItemsDTO;
import com.ecommerce.entity.OrderItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemsMapper extends EntityMapper<OrderItemsDTO, OrderItems> {
}
