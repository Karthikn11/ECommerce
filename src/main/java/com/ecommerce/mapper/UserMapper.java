package com.ecommerce.mapper;

import com.ecommerce.dto.UserDTO;
import com.ecommerce.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User>{
}
