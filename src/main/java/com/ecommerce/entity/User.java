package com.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank(message = "Username is required")
    @Column(name="username")
    private String userName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(name="email")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @Column(name="phoneNumber")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    @Column(name="address")
    private String address;
}
