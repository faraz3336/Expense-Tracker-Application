package com.faraz.expenseTracker.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
// import lombok.AllArgsConstructor;
import lombok.*;
// import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false, length = 100)
    @NotBlank
    private String username;
    @Email
    @NotBlank
    @Column(nullable = false, unique = true, length = 150)
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String password;
}
