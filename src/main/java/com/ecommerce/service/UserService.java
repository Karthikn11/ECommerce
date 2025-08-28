package com.ecommerce.service;

import com.ecommerce.dto.UserDTO;
import com.ecommerce.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

   List<UserDTO> getAllUser();

   UserDTO findUserById(Long id);

   void deleteUser(Long id);
}
