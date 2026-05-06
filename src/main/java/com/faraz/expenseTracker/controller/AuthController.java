package com.faraz.expenseTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faraz.expenseTracker.dto.LoginRequest;
import com.faraz.expenseTracker.models.User;
import com.faraz.expenseTracker.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        System.out.println("🔥 LOGIN API HIT");
        System.out.println("EMAIL: " + request.getIdentifier());
        System.out.println("PASSWORD: " + request.getPassword());

        return authService.login(request.getIdentifier(), request.getPassword());
    }
}
