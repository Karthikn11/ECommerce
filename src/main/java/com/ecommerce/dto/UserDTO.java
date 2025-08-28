package com.ecommerce.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Long id;

    private String userName;

    private String email;

    private String phoneNumber;

    private String address;

}
