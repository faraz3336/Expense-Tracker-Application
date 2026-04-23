package com.faraz.expenseTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faraz.expenseTracker.models.User;
import com.faraz.expenseTracker.repository.UserRepository;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public String register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already in use";
        }
        userRepository.save(user);
        return "User registered successfully";
    }

}
