package com.ecommerce.mapper;

import com.ecommerce.dto.OrderDTO;
import com.ecommerce.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
}
