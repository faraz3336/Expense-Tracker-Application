package com.faraz.expenseTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.faraz.expenseTracker.dto.LoginRequest;
import com.faraz.expenseTracker.models.Role;
import com.faraz.expenseTracker.models.User;
import com.faraz.expenseTracker.repository.UserRepository;
import com.faraz.expenseTracker.security.JwtUtils;

import lombok.extern.java.Log;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    public AuthService(UserRepository userRepository, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
    }

    public String register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already in use";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
        return "User registered successfully";
    }

    public String login(String identifier, String password) {

        User user;
        if (identifier.contains("@")) {
            user = userRepository.findByEmail(identifier).orElseThrow(() -> new RuntimeException("User not found"));
        } else {
            user = userRepository.findByUsername(identifier).orElseThrow(() -> new RuntimeException("User not found"));
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtils.generateToken(user.getEmail(), user.getRole().name());
    }

}
