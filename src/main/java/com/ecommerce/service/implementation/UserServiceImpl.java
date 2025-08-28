package com.ecommerce.service.implementation;

import com.ecommerce.dto.UserDTO;
import com.ecommerce.entity.User;
import com.ecommerce.mapper.UserMapper;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository =  userRepository;
        this.userMapper =  userMapper;
    }
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> userliSt = userRepository.findAll();
        return userMapper.toDto(userliSt);
    }

    @Override
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
     return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
