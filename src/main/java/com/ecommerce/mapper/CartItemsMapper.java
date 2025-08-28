package com.ecommerce.mapper;

import com.ecommerce.dto.CartItemsDTO;
import com.ecommerce.entity.CartItems;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartItemsMapper extends EntityMapper<CartItemsDTO, CartItems> {
}
