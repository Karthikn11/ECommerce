package com.ecommerce.controller;

import com.ecommerce.dto.UserDTO;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/application")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
      UserDTO createdUser = userService.createUser(userDTO);
      return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/user")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        UserDTO updatedUser = userService.createUser(userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getAllUser() {
       List<UserDTO> userList = userService.getAllUser();
       return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id){
        UserDTO user = userService.findUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
